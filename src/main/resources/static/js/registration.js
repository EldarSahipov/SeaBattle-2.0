let user_id
function saveUserAndProfile() {
    if(TestLogin1(login) && TestLogin1(password)) {
        let date = new Date();
        $.ajax({
            url: '/regist',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                role: 'USER',
                login: document.getElementById('login').value,
                password: document.getElementById('psw').value,
                nickname: document.getElementById('nickname').value,
                regist_date: date,
                status: 'ACTIVE'
            }),
            success: function (data) {
                user_id = data
                saveProfileReg();
            }
        })
    }
}
function saveProfileReg() {
    $.ajax({
        url: '/profile/reg_profile',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            rang: 'РЫБАК',
            matches: 0,
            wins: 0,
            wins_streak: 0,
            user_id: user_id,
            is_playing: 0,
            is_searching: 0
        }),
        success: function () {
            document.location.href = "/main";
        }
    })
}

let login = document.getElementById('login').value
let password = document.getElementById('password').value
function TestLogin1(str){
    if(/^[a-zA-z]{1}[a-zA-Z1-9]{4,26}$/.test(str) === false)
    {
        alert('Не верный логин или пароль');
        return false;
    }
    return true;
}

