
function findId() {
    let rang = document.getElementById('rang')
    $.get('/profile', function (data) {
    })

}

function myProfile () {
    let rang = document.getElementById('rang')
    $.ajax({
        url: '/profile',
        method: 'GET',
        contentType: 'application/json',
        data: JSON.stringify(user),
        success: function (data) {
            document.location.href = "/profile/";
        }
    })
}