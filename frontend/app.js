const API = "http://localhost:8080/bookings";

function createBooking() {
    const customer = customer.value;
    const serviceType = service.value;

    fetch(`${API}?customer=${customer}&serviceType=${serviceType}`, {
        method: "POST"
    })
    .then(res => res.json())
    .then(data => createResult.textContent = JSON.stringify(data, null, 2));
}

function assign() {
    fetch(`${API}/${bookingId.value}/assign?provider=${provider.value}`, { method: "POST" })
        .then(res => res.json())
        .then(data => actionResult.textContent = JSON.stringify(data, null, 2));
}

function start() {
    fetch(`${API}/${bookingId.value}/start`, { method: "POST" })
        .then(res => res.json())
        .then(data => actionResult.textContent = JSON.stringify(data, null, 2));
}

function complete() {
    fetch(`${API}/${bookingId.value}/complete`, { method: "POST" })
        .then(res => res.json())
        .then(data => actionResult.textContent = JSON.stringify(data, null, 2));
}

function cancel() {
    fetch(`${API}/${bookingId.value}/cancel`, { method: "POST" })
        .then(res => res.json())
        .then(data => actionResult.textContent = JSON.stringify(data, null, 2));
}

function loadBookings() {
    fetch(API)
        .then(res => res.json())
        .then(data => allBookings.textContent = JSON.stringify(data, null, 2));
}
