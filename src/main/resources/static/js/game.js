
let id_table_1;
let id_table_2 = "enemys";

let motion = 1;
let score = 0;

game_start();
function game_start() {
    $.get('/game_start/' + 1, function (data) {
        console.log(data)
        if (data == 1) {

            id_table_1 = 1;
            pause = true
            start();
        } else {
            id_table_1 = 2;
            pause = true
            start();

        }

    })

}

let pause = false

setInterval(function(){
    if (pause == true)
    {
        $.get('/cheking/' + id_table_1, function (data) {

            var tds = document.getElementById(id_table_1).getElementsByTagName('td');
            var massiv = []

            for (var i = 0; i < 10; i++) {
                for (var j = 0; j < 10; j++) {
                    massiv.push(data[i][j]);
                }
            }
            for (var i = 0; i < tds.length; i++) {
                if (massiv[i] == 11) {
                    tds[i].className = 'redy'
                }
                if (massiv[i] == 10) {
                    tds[i].className = 'grayy'
                }
            }

        })
    }


}, 1000);




// let tds = document.querySelectorAll('td');


function tableCreate_1(u) {
    tbl = document.createElement('table');
    tbl.setAttribute("id", id_table_1);

    for (var i = 0; i < u; i++) {
        var tr = tbl.insertRow();

        for (var j = 0; j < u; j++) {

            var td = tr.insertCell();


        }
    }
    //body.appendChild(tbl);
    var hereDiv = document.getElementById("left")
    hereDiv.appendChild(tbl)

    var t = document.getElementById(id_table_1);
    var trs = t.getElementsByTagName("tr");
    var tds = null;

    for (var i = 0; i < trs.length; i++) {
        tds = trs[i].getElementsByTagName("td");
        for (var n = 0; n < trs.length; n++) {
            tds[n].innerHTML = ".";
        }
    }

    tbl.classList.add("t");
}

function tableCreate_2(u) {
    tbl = document.createElement('table');
    tbl.setAttribute("id", id_table_2);

    for (var i = 0; i < u; i++) {
        var tr = tbl.insertRow();

        for (var j = 0; j < u; j++) {

            var td = tr.insertCell();


        }
    }
    //body.appendChild(tbl);
    var hereDiv = document.getElementById("right")
    hereDiv.appendChild(tbl)

    var t = document.getElementById(id_table_2);
    var trs = t.getElementsByTagName("tr");
    var tds = null;

    for (var i = 0; i < trs.length; i++) {
        tds = trs[i].getElementsByTagName("td");
        for (var n = 0; n < trs.length; n++) {
            tds[n].innerHTML = ".";
        }
    }

    tbl.classList.add("t");
}




function add() {
    variable = document.querySelector(".t").getAttribute("id");
    console.log(variable)

    $.get('/add/' + id_table_1, function (data) {
        // console.log(data)
        var tds = document.getElementById(id_table_1).getElementsByTagName('td');
        var massiv = []

        for (var i = 0; i < 10; i++) {
            for (var j = 0; j < 10; j++) {
                massiv.push(data[i][j]);
            }
        }
        for (var i = 0; i < tds.length; i++) {
            if (massiv[i] == 1) {
                tds[i].className = 'greeny'
            }
        }
    })



}

function start()
{
    tableCreate_1(10);
    tableCreate_2(10);
    add();
    // document.getElementById("butt").style.display = "none"
    document.getElementById(id_table_2).onclick = (event) => {
        let cell = event.target;
        if (cell.tagName.toLowerCase() != 'td')
            return;
        let i = cell.parentNode.rowIndex;
        let j = cell.cellIndex;
        console.log(i, j);
//document.getElementById('d').innerHTML = `${i},${j}`

        var target = event.target;
        if ((target.textContent == ".") && (motion == id_table_1)) {
            var str = id_table_1 + "" + i + "" + j
            $.get('/check_field/' + str, function (data) {
                if (target.tagName === 'TD') {

                    if (data == 1) {
                        target.classList.toggle('redy');
                        target.innerHTML = "х"
                        if (id_table_1 == 1 ) {
                            score = 11111111
                        }
                        else if (id_table_1 == 2) {
                            score = 2222222
                        }

                    } else {
                        target.classList.toggle('grayy');
                        target.innerHTML = "o"
                        if(motion == 2)
                        {
                            motion = 1;
                            $.get('/motion_update/' + motion, function (data) {
                                console.log(data);

                            })
                        }
                        else if(motion == 1)
                        {
                            motion = 2;
                            $.get('/motion_update/' + motion, function (data) {
                                console.log(data);

                            })
                        }

                    }

                }
            })
        }
    }
}


setInterval(function(){
    console.log(score)
    $.get('/motion/' + motion, function (data) {
        score = 0;
        // console.log(data);
        if (data == 2)
        {
            motion = 2;
            document.getElementById('motion').innerHTML = " Ходит id: 2 "

        }
        else if (data == 1)
        {
            motion = 1;
            document.getElementById('motion').innerHTML = " Ходит id: 1 "
        }
    })
},500);



setInterval(function(){
    if (score == 1 || score == 2)
    {
        $.get('/winner/' + score, function (data) {
            console.log(data);
            if (data == 1)
            {
                alert("Выиграл 1 игрок")
            }
            if (data == 2)
            {
                alert("Выиграл 2 игрок")
            }
        })
    }
    score = 0;
},100);

/*

    tds.forEach((item) => {
        item.onclick = (e) => {
            var str = i + "" + j
            console.log(ij)
            $.get('/check_field/' + str, function (data) {
                console.log(data)
                if (data == 1)
                {
                    e.target.classList.toggle('redy')
                }
                else
                {
                    e.target.classList.toggle('grayy')
                }
            })

        }
    })
 */


























/*let tds = document.querySelectorAll('td');

tds.forEach((item) => {
    item.onclick = (e) => {
        $.get('/check_field/' + document.getElementById('d').innerHTML.value, function (data) {
            if (data == 1)
            {
                e.target.classList.toggle('redy')
            }
            else
            {
                e.target.classList.toggle('grayy')
            }
        })
    }
});

/*
function checkfield() {
    $.get('/check_field/' + document.getElementById('d').innerHTML.value, function (data) {
        if (data == 1) {
            let tds = document.querySelectorAll('td');
            tds.forEach((item) => {
                item.onclick = (e) => {
                    e.target.classList.toggle('grayy')
                }
            });
        }
        if (data == 0) {
            let tds = document.querySelectorAll('td');
            tds.forEach((item) => {
                item.onclick = (e) => {
                    e.target.classList.toggle('redy')
                }
            });
        }

    })
}*/

