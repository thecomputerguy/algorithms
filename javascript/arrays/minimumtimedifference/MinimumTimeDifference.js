function convertToMinutes(timestamps){
    let minutesList = new Array(1440)
    minutesList.fill(false)
    for (let index = 0; index < timestamps.length; index++) {
        let [hours, minutes] = timestamps[index].split(":");
        minutes = parseInt(minutes) + parseInt(hours) * 60
        minutesList[minutes] = true
    }
    return minutesList
}

function minimumTimeDiff(timestamps){
    if(!timestamps) return 0
    const minutesSeen = convertToMinutes(timestamps)
    
    let minDiff = Number.MAX_VALUE
    let firstTime = null
    let previousTime = null
    for (let currentTime = 0; currentTime < minutesSeen.length; currentTime++) {
        if(minutesSeen[currentTime]){
            if(firstTime == null){
                firstTime = currentTime
                previousTime = currentTime
            }else{
                minDiff = Math.min(minDiff, Math.min(currentTime - previousTime, 1440 - currentTime + previousTime))
                previousTime = currentTime
            }
        }    
    }
    return minDiff
}


const result = minimumTimeDiff(["23:59", "00:00"])
console.log(`Minimum diff: ${result}`)