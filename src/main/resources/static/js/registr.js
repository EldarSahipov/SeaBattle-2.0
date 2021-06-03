function addUser() {
    let date = new Date();
    $.ajax({
        url: '/add_user',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            role: '0', // 0 - игрок, 1 - администратор
            login: document.getElementById('login').value,
            password: document.getElementById('psw').value,
            nickname: document.getElementById('nickname').value,
            regist_date: date
        }),
        success: function () {
            document.location.href = "/profile";
        }
    })
}