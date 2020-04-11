/*var nums = [];

function addNumber() {
	var txt = document.getElementById("txtNumber").value;
	var number = parseInt(txt);
	if (isNaN(number))
		alert(txt+" is not a number!");
	else {
		nums.push(number);
				redrawTable();
	}
}

function redrawTable() {
	var html = "<table border='1'><th>Nums</th><th>Delete</th>";
	for (var i=0; i<nums.length; i++) {
		html += "<tr><td>"+nums[i]+"</td><td><button onClick=deleteTable("+i+")>0</button></td></tr>";
	}
	html += "</table>";
	document.getElementById("pOutput").innerHTML = html;
}
 
function deleteTable(i) {
    nums.splice(i,1);
    redrawTable();
}*/

function start() {
	var startDay = prompt("What day does your month start on?" + "\n" + "0 = Sunday, 1 = Monday etc..");
	var daysInput = prompt("How many days are in your month?");

	drawTable(startDay, daysInput);
}

function drawTable(startDay, daysInput) {
	var html = "<table border='1'><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th>";
	var count = 7 - startDay;
	html += "<tr>";
	var today = new Date();
	var date = today.getDate() - 1;
	var i;

	for (i = 0; i < startDay; i++) {
		html += "<td></td>"
	}

	for (i = 0; i < daysInput; i++) {

		if ((count != 0) && ((i + 1) == today.getDate())) {
			html += "<td style='background-color: pink; text-decoration: underline'>" + (i + 1) + "</td>";
			count--;
			i++;
		}

		if (count != 0) {
			html += "<td style='background-color: red'>" + (i + 1) + "</td>";
			count--;
		}

		else if ((count == 0) && (i + 1 == date)) {
			count = 6;
			html += "<tr><td style='background-color: pink; text-decoration: underline'>" + (i + 1) + "</td>";
		}

		else if ((count == 0) && !(i + 1 == date)) {
			count = 6;
			html += "</tr><tr>" + "<td style='background-color: red'>" + (i + 1) + "</td>";
		}
	}

	if (count <= 7) {
		for (var y = 0; y < count; y++) {
			html += "</td><td>";
		}
	}

	html += "</table>";
	document.getElementById("pOutput").innerHTML = html;
}