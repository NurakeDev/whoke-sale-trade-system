const registrationForm = document.querySelector('#registration-form');
registrationForm.addEventListener('submit', register);

async function register(event) {
    event.preventDefault();

    const fullName = document.querySelector('#fullName').value;
    const phoneNumber = document.querySelector('#phoneNumber').value;
    const password = document.querySelector('#password').value;
    const confirmationPassword = document.querySelector('#confirmationPassword').value;
    const address = form.querySelector('address').value;
    const role = form.querySelector('role').value;

    if (password !== confirmationPassword) {
        alert('Parollar mos kelmaydi!');
        return;
    }

    const data = {
        fullName,
        phoneNumber,
        password,
        address,
        role: [],
        orders: []
    };

}