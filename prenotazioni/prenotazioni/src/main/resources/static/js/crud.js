$(document).ready(function() {

    // Users CRUD Operations

    // Function to load all users
    function loadUsers() {
        $.ajax({
            type: "GET",
            url: "/api/controller/user/get",
            success: function(users) {
                $("#userList").empty();
                if (users.length > 0) {
                    users.forEach(function(user) {
                        $("#userList").append(`<div>ID: ${user.id}, Name: ${user.name}, Surname: ${user.surname}, Phone: ${user.phone}</div>`);
                    });
                } else {
                    $("#userList").append("<div>No users found.</div>");
                }
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    }

    // Load all users on page load
    loadUsers();

    // Handle form submission for adding a user
    $("#userForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            name: $("#userName").val(),
            surname: $("#userSurname").val(),
            phone: $("#userPhone").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/controller/user/add",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadUsers();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for getting a user by ID
    $("#getUserByIdForm").on("submit", function(event) {
        event.preventDefault();
        const userId = $("#userIdGet").val();
        $.ajax({
            type: "GET",
            url: `/api/controller/user/get/${userId}`,
            success: function(user) {
                $("#userByIdResult").html(`<div>ID: ${user.id}, Name: ${user.name}, Surname: ${user.surname}, Phone: ${user.phone}</div>`);
            },
            error: function(error) {
                alert("Error: " + error.responseText);
                $("#userByIdResult").html("<div>User not found.</div>");
            }
        });
    });

    // Handle form submission for updating a user
    $("#updateUserForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            id: $("#userIdUpdate").val(),
            name: $("#userNameUpdate").val(),
            surname: $("#userSurnameUpdate").val(),
            phone: $("#userPhoneUpdate").val()
        };
        $.ajax({
            type: "PUT",
            url: "/api/controller/user/update",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadUsers();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for deleting a user
    $("#deleteUserForm").on("submit", function(event) {
        event.preventDefault();
        const userId = $("#userIdDelete").val();
        $.ajax({
            type: "DELETE",
            url: `/api/controller/user/delete/${userId}`,
            success: function(response) {
                alert(response);
                loadUsers();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });


    // Tables CRUD Operations

    // Function to load all tables
    function loadTables() {
        $.ajax({
            type: "GET",
            url: "/api/controller/table/get",
            success: function(tables) {
                $("#tableList").empty();
                if (tables.length > 0) {
                    tables.forEach(function(table) {
                        $("#tableList").append(`<div>ID: ${table.id}, Seats: ${table.seats}, Table Type: ${table.tableType}</div>`);
                    });
                } else {
                    $("#tableList").append("<div>No tables found.</div>");
                }
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    }

    // Load all tables on page load
    loadTables();

    // Handle form submission for adding a table
    $("#tableForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            seats: $("#tableSeats").val(),
            tableType: $("#tableType").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/controller/table/add",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadTables();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for getting a table by ID
    $("#getTableByIdForm").on("submit", function(event) {
        event.preventDefault();
        const tableId = $("#tableIdGet").val();
        $.ajax({
            type: "GET",
            url: `/api/controller/table/get/${tableId}`,
            success: function(table) {
                $("#tableByIdResult").html(`<div>ID: ${table.id}, Seats: ${table.seats}, Table Type: ${table.tableType}</div>`);
            },
            error: function(error) {
                alert("Error: " + error.responseText);
                $("#tableByIdResult").html("<div>Table not found.</div>");
            }
        });
    });

    // Handle form submission for updating a table
    $("#updateTableForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            id: $("#tableIdUpdate").val(),
            seats: $("#tableSeatsUpdate").val(),
            tableType: $("#tableTypeUpdate").val()
        };
        $.ajax({
            type: "PUT",
            url: "/api/controller/table/update",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadTables();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for deleting a table
    $("#deleteTableForm").on("submit", function(event) {
        event.preventDefault();
        const tableId = $("#tableIdDelete").val();
        $.ajax({
            type: "DELETE",
            url: `/api/controller/table/delete/${tableId}`,
            success: function(response) {
                alert(response);
                loadTables();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });


    // Reservations CRUD Operations

    // Function to load all reservations
    function loadReservations() {
        $.ajax({
            type: "GET",
            url: "/api/controller/reservation/get",
            success: function(reservations) {
                $("#reservationList").empty();
                if (reservations.length > 0) {
                    reservations.forEach(function(reservation) {
                        $("#reservationList").append(`<div>ID: ${reservation.id}, User ID: ${reservation.userId}, Guests: ${reservation.numberOfGuests}, Table Type: ${reservation.tableType}, Date: ${reservation.date}, Start Time: ${reservation.startTime}</div>`);
                    });
                } else {
                    $("#reservationList").append("<div>No reservations found.</div>");
                }
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    }

    // Load all reservations on page load
    loadReservations();

    // Handle form submission for adding a reservation
    $("#reservationForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            userId: $("#reservationUserId").val(),
            numberOfGuests: $("#reservationNumberOfGuests").val(),
            tableType: $("#reservationTableType").val(),
            date: $("#reservationDate").val(),
            startTime: $("#reservationStartTime").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/controller/reservation/add",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadReservations();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for getting a reservation by ID
    $("#getReservationByIdForm").on("submit", function(event) {
        event.preventDefault();
        const reservationId = $("#reservationIdGet").val();
        $.ajax({
            type: "GET",
            url: `/api/controller/reservation/get/${reservationId}`,
            success: function(reservation) {
                $("#reservationByIdResult").html(`<div>ID: ${reservation.id}, User ID: ${reservation.userId}, Guests: ${reservation.numberOfGuests}, Table Type: ${reservation.tableType}, Date: ${reservation.date}, Start Time: ${reservation.startTime}</div>`);
            },
            error: function(error) {
                alert("Error: " + error.responseText);
                $("#reservationByIdResult").html("<div>Reservation not found.</div>");
            }
        });
    });

    // Handle form submission for updating a reservation
    $("#updateReservationForm").on("submit", function(event) {
        event.preventDefault();
        const data = {
            id: $("#reservationIdUpdate").val(),
            userId: $("#reservationUserIdUpdate").val(),
            numberOfGuests: $("#reservationNumberOfGuestsUpdate").val(),
            tableType: $("#reservationTableTypeUpdate").val(),
            date: $("#reservationDateUpdate").val(),
            startTime: $("#reservationStartTimeUpdate").val()
        };
        $.ajax({
            type: "PUT",
            url: "/api/controller/reservation/update",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(response) {
                alert(response);
                loadReservations();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    // Handle form submission for deleting a reservation
    $("#deleteReservationForm").on("submit", function(event) {
        event.preventDefault();
        const reservationId = $("#reservationIdDelete").val();
        $.ajax({
            type: "DELETE",
            url: `/api/controller/reservation/delete/${reservationId}`,
            success: function(response) {
                alert(response);
                loadReservations();
            },
            error: function(error) {
                alert("Error: " + error.responseText);
            }
        });
    });

});
