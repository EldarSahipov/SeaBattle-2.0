let pause = false;

function search() {
    console.log(document.getElementById('search').textContent[9])
    document.getElementById("start_game").disabled = true;

    $.get('/search_game/' + 1, function (data) {
        pause = true;
    })
}
setInterval(function(){
    $.get('/chek_id', function (data) {
        if (data == 2)
        {
            document.getElementById('search').innerHTML = "Игроков: 2/2"
            window.location.href='/game'
        }
        else if (data == 1)
        {
            document.getElementById('search').innerHTML = "Игроков: 1/2"
        }
    })
},500)
