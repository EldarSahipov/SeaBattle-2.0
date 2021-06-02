function saveUser() {
    let date = new Date();
    let user = {
        role: 'USER',
        login: document.getElementById('login').value,
        password: document.getElementById('psw').value,
        nickname: document.getElementById('nickname').value,
        regist_date: date,
        expire_date: date,
        is_deleted: date,
        is_banned: date,
        status: 'ACTIVE'
    }
    $.ajax({
        url: '/regist',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(user),
        success: function () {
            document.location.href = "/profile";
        }
    })
}