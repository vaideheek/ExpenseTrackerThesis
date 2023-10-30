// Function to toggle the sidebar
const toggleSidebar = () => {
    const sidebar = document.getElementById("sidebar");
    if (sidebar.style.left === "0px" || sidebar.style.left === "") {
        sidebar.style.left = "-250px";
    } else {
        sidebar.style.left = "0px";
    }
};

// Event listener for the sidebar toggle button
document.addEventListener("DOMContentLoaded", function () {
    const sidebarToggle = document.getElementById("sidebarToggle");
    sidebarToggle.addEventListener("click", toggleSidebar);

    // Get a reference to the sidebar
    const sidebar = document.getElementById("sidebar");

    // Close the sidebar when the cursor leaves the sidebar
    sidebar.addEventListener("mouseleave", () => {
        if (sidebar.style.left === "0px") {
            toggleSidebar();
        }
    });
});

// Hide the sidebar when the cursor enters the container


// Function to add income
document.addEventListener("DOMContentLoaded", function () {
    const incomeForm = document.getElementById("incomeForm");
    incomeForm.addEventListener("submit", function (e) {
        e.preventDefault(); // Prevent the default form submission

        // Gather form data
        const sourceName = document.getElementById("sourceName").value;
        const amount = parseFloat(document.getElementById("amount").value);
        const incomeDate = document.getElementById("incomeDate").value;

        // Retrieve the selected category from the dropdown menu
        const categorySelect = document.getElementById("category");
        const category = categorySelect.options[categorySelect.selectedIndex].value;

        // Create a data object to send to the server
        const data = {
            sourceName: sourceName,
            amount: amount,
            incomeDate: incomeDate,
            category: category, // Include the selected category
        };

        // Send a POST request to the server to add the income record
        fetch("/incomes/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((data) => {
                // Handle the response, e.g., update the incomes table and charts
                console.log(data); // Data can be the newly created income record

                // Get a reference to the incomes table
                const incomesTable = document.getElementById("incomesTable");

                // Create a new row for the table
                const newRow = incomesTable.insertRow();

                // Assuming 'data' contains the income details, update the table cells
                const sourceNameCell = newRow.insertCell(0);
                sourceNameCell.innerHTML = data.sourceName;

                const categoryCell = newRow.insertCell(1);
                categoryCell.innerHTML = data.category;

                const amountCell = newRow.insertCell(2);
                amountCell.innerHTML = data.amount;

                const incomeDateCell = newRow.insertCell(3);
                incomeDateCell.innerHTML = data.incomeDate;

                const actionsCell = newRow.insertCell(4);
                actionsCell.innerHTML = `<button onclick="editIncome(this)">Edit</button> <button onclick="deleteIncome(this)">Delete</button>`;

                // Update the charts after adding a new income record
                fetch('/incomes/all') // Fetch the updated income data
                    .then((response) => response.json())
                    .then((newData) => {
                        // Generate the pie and bar charts with the updated income data
                        createIncomeDistributionChart(newData);
                        createMonthlyIncomeChart(newData);
                    })
                    .catch((error) => {
                        console.error('Error fetching updated income data:', error);
                    });

                updateCharts();
            })

            .catch((error) => {
                console.error("Error:", error);
            });
    });
});

// Function to fetch and display income data
function displayIncomeTable() {
    fetch('/incomes/all') // Replace with your actual backend API endpoint
        .then((response) => response.json())
        .then((data) => {
            const tableBody = document.querySelector('tbody'); // Assuming you have a <tbody> element in your table

            // Clear existing table rows
            tableBody.innerHTML = '';

            // Loop through the fetched data and create table rows
            data.forEach((income) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                  <td>${income.sourceName}</td>
                  <td>${income.amount}</td>
                  <td>${income.incomeDate}</td>
                  <td>${income.category}</td>
                  <td class="actions">
                    <button onclick="editIncome(this)">Edit</button>
                    <button onclick="deleteIncome(this)">Delete</button>
                  </td>
                  <td class="hidden">${income.id}</td>
                `;

                tableBody.appendChild(row);
            });

            // Generate the pie chart with income data
            createIncomeDistributionChart(data);

            // Generate the bar chart with income data
            createMonthlyIncomeChart(data);
        })
        .catch((error) => {
            console.error('Error fetching income data:', error);
        });
}

// Call the function to populate the table when the page loads
displayIncomeTable();

// Function to pre-fill modal with income data
function editIncome(button) {
    // Get the row containing income data
    const row = button.closest('tr');

    // Extract the data from the row, including the id
    const sourceName = row.cells[0].innerText;
    const amount = row.cells[1].innerText;
    const incomeDate = row.cells[2].innerText;
    const category = row.cells[3].innerText;
    const incomeId = row.querySelector('.hidden').innerText; // This retrieves the hidden id

    // Pre-fill the modal input fields with the data
    document.getElementById('editSourceName').value = sourceName;
    document.getElementById('editAmount').value = amount;
    document.getElementById('editIncomeDate').value = incomeDate;

    // Set the selected category in the dropdown menu
    const editCategorySelect = document.getElementById('editCategory');
    for (let i = 0; i < editCategorySelect.options.length; i++) {
        if (editCategorySelect.options[i].value === category) {
            editCategorySelect.selectedIndex = i;
            break;
        }
    }

    // Store the incomeId in a variable to use when updating
    currentIncomeId = incomeId;

    // Show the modal
    $('#editModal').modal('show');
}

// Function to update income record
function updateIncome() {
    // Get the edited data from the modal input fields
    const sourceName = document.getElementById('editSourceName').value;
    const amount = document.getElementById('editAmount').value;
    const incomeDate = document.getElementById('editIncomeDate').value;

    // Create an object with the updated data
    const updatedIncome = {
        sourceName: sourceName,
        amount: amount,
        incomeDate: incomeDate,
    };

    // Get the income ID (you'll need to obtain the income ID from the selected record)
    const incomeId = currentIncomeId/* You need to obtain the income ID from the selected record */;

    // Make an AJAX or fetch request to update the income record
    fetch(`/incomes/update/${incomeId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedIncome),
    })
        .then((response) => {
            if (response.ok) {
                // If the update is successful, close the modal and refresh the income table
                $('#editModal').modal('hide');
                displayIncomeTable();
            } else {
                // Handle any errors here
                console.error('Failed to update income record.');
            }
            updateCharts();
        })
        .catch((error) => {
            console.error('Error updating income record:', error);
        });
}

// Function to delete an income record
function deleteIncome(button) {
    const row = button.closest('tr');
    const incomeId = row.querySelector('.hidden').innerText; // Retrieve the income ID

    // Confirm with the user before deleting
    const confirmDelete = confirm('Are you sure you want to delete this income record?');

    if (confirmDelete) {
        // Make an AJAX or fetch request to delete the income record
        fetch(`/incomes/delete/${incomeId}`, {
            method: 'DELETE',
        })
            .then((response) => {
                if (response.ok) {
                    // If the deletion is successful, remove the row from the table
                    row.remove();
                    // After deletion, update the charts
                    // Update the charts after deleting an income record
                    fetch('/incomes/all') // Fetch the updated income data
                        .then((response) => response.json())
                        .then((newData) => {
                            // Generate the pie and bar charts with the updated income data
                            createIncomeDistributionChart(newData);
                            createMonthlyIncomeChart(newData);
                        })
                        .catch((error) => {
                            console.error('Error fetching updated income data:', error);
                        });
                    updateCharts();
                } else {
                    // Handle any errors here
                    console.error('Failed to delete income record.');
                }
            })
            .catch((error) => {
                console.error('Error deleting income record:', error);
            });
    }
}

// Function to update the charts
function updateCharts() {
    // Fetch the latest income data
    fetch('/incomes/all')
        .then((response) => response.json())
        .then((data) => {
            // Generate the pie and bar charts with the updated income data
            createIncomeDistributionChart(data);
            createMonthlyIncomeChart(data);
        })
        .catch((error) => {
            console.error('Error fetching updated income data:', error);
        });
}

// Function to create the pie chart
function createIncomeDistributionChart(incomeData) {
    const categories = {}; // To store income distribution by category

    // Calculate income distribution
    incomeData.forEach((income) => {
        const category = income.category;
        if (categories[category]) {
            categories[category] += income.amount;
        } else {
            categories[category] = income.amount;
        }
    });

    const labels = Object.keys(categories);
    const data = Object.values(categories);

    const ctx = document.getElementById('incomePieChart');

    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: 'Income Distribution',
                data: data,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 205, 86, 0.2)',
                    // Add more colors as needed
                ],
                borderColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)',
                    // Add more colors as needed
                ],
                borderWidth: 1,
            }],
        },
        options: {
            responsive: true,
        },
    });
}


// Function to create the bar chart
function createMonthlyIncomeChart(incomeData) {
    const months = {}; // To store income by month

    // Calculate income by month
    incomeData.forEach((income) => {
        const incomeDate = moment(income.incomeDate); // Parse income date
        const month = incomeDate.format('MMMM YYYY'); // Format the month

        if (months[month]) {
            months[month] += income.amount;
        } else {
            months[month] = income.amount;
        }
    });

    const labels = Object.keys(months);
    const data = Object.values(months);

    const ctx = document.getElementById('incomeBarChart'); // Use the same canvas as the pie chart

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Monthly Income',
                data: data,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
            }],
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                },
            },
        },
    });
}

