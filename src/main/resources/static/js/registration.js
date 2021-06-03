function saveUserAndProfile() {
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
            document.location.href = "/profile";
        }
    })
    // $.ajax({
    //     url: '/reg/profile',
    //     method: 'POST',
    //     contentType: 'application/json',
    //     data: JSON.stringify({
    //         rang: "РЫБАК",
    //         matches: 0,
    //         wins: 0,
    //         wins_streak: 0,
    //         is_playing: 0,
    //         is_searching: 0,
    //     })
    // })
}