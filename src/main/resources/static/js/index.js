function clock() {
    var now = new Date();
    hours = now.getHours();
    minutes = now.getMinutes();
    hours = ((hours + 11) % 12 + 1)
    if (minutes < 10) {
      time = hours + ":" + "0" + minutes;
    } else {
      time = hours + ":" + minutes;
    }
    document.getElementById("date").innerHTML = now.toDateString();
    document.getElementById("time").innerHTML = time;
    setTimeout(clock, 1000);
  }
  clock();