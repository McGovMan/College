var i = 0, count = 1;
var year = 2019;
var month = 1;

var today = new Date();
var date = today.getDate();

function numOfDays(month){
    if (month == 9 || month == 4 || month == 6 || month == 11) return 30;
    if (month != 2) return 31;

    return 28;
}

function isLeapYear(year) {
    if ((1900 - year) % 100 === 0 || (1900 - year) % 400 === 0 || (1900 - year) % 4 === 0) {
        return 1;
    }
    return 0;
}

function newYearsDay(year) { // calculates day of the week of Jan 1st in any year >=1900
    var daynumber = 1; // Jan 1st 1900 = a Monday
    for (var i=1900; i<year; i++){ // loop for each elapsed year	
        daynumber+=365 + isLeapYear(i);  // add 365 or 366 for each elapsed year
    }					
    return (daynumber % 7);
}

function startDay(year) { // calculates day of week of 1st of any month after Jan 1900
    var daynumber = newYearsDay(year); // day of week of Jan 1 this year
    for (var i =1; i < month; i++){ // loop for each elapsed month this year
        daynumber += numOfDays(i); // add days in each elapsed month
    }
    daynumber -= 1
    daynumber %= 7;
    return daynumber; // what day of the week the month starts on
}

function drawTable() {
    year = parseInt(window.prompt("Enter a year after 1900", "Enter here"));
    month = parseInt(window.prompt("Enter the month (1 = January, 2 = Febuary etc..", "Enter here"));

    var html = "<table border='1'><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th>";
    html += "<tr>";
    startDay = startDay(year);
    i = 0;

    while (count <= numOfDays(month) + isLeapYear(year)) {
        if (i % 7 === 0 && i != 0) html += "</tr><tr>";
        while (i < startDay) {
            html += "<td></td>";
            i++;
        }

        if (count == date) {
            html += "<td style='background-color: pink; text-decoration: underline'>" + count + "</td>"
        }
        if (!(count == date)) {
            html += "<td>" + count + "</td>";
        }
        count++;
        i++;
    }

    while (!(i % 7 === 0)) {
        html += "<td></td>";
        i++;
    }
    html += "</tr></table>";
	document.getElementById("pOutput").innerHTML = html;
}