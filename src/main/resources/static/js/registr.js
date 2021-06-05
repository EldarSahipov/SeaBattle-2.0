// function addUser() {
//     let date = new Date();
//     $.ajax({
//         url: '/add_user',
//         method: 'POST',
//         contentType: 'application/json',
//         data: JSON.stringify({
//             role: '0', // 0 - игрок, 1 - администратор
//             login: document.getElementById('login').value,
//             password: document.getElementById('psw').value,
//             nickname: document.getElementById('nickname').value,
//             regist_date: date
//         }),
//         success: function (data) {
            // $.ajax({
            //     url: '/reg/profile',
            //     method: 'POST',
            //     contentType: 'application/json',
            //     data: JSON.stringify({
            //         rang: 'РЫБАК',
            //         matches: 0,
            //         wins: 0,
            //         wins_streak: 0,
            //         user_id: data,
            //         is_playing: 0,
            //         is_searching: 0
            //     }),
            //     success: function () {
            //         document.location.href = "/profile";
            //     }
            // })
//             alert(data);
//         }
//     })
// }