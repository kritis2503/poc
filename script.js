let play=document.querySelector("#play");
let video=document.querySelector(".video");
let startRecording=document.querySelector('#startRecording');
let pauseRecording=document.querySelector('#pauseRecording');
let stopRecording=document.querySelector("#stopRecording");
let downloadRecording=document.querySelector("#downloadRecording");
let vidSave=document.querySelector('#vid2');
// let recorder= new MediaRecorder(video);

play.addEventListener('click',function(){
    if(video.paused)video.play();
    else video.pause();
});


if (navigator.mediaDevices) {
    console.log('getUserMedia supported.');
  
    var constraints = { audio: true };
    var chunks = [];
  
    navigator.mediaDevices.getUserMedia(constraints)
    .then(function(stream) {
  
      var mediaRecorder = new MediaRecorder(stream);
  
    //   visualize(stream);

        startRecording.addEventListener('click',function(ev){
            if(mediaRecorder.state=='inactive')
                mediaRecorder.start();
            else
                alert('recording has been started');
            console.log(mediaRecorder.state);
        });

        pauseRecording.addEventListener('click',function(ev){
            if(mediaRecorder.state=='recording')
                mediaRecorder.pause();
            else   if(mediaRecorder.state=='paused')mediaRecorder.resume();
            else alert('Recording not started');
            console.log(mediaRecorder.state);
        });

        stopRecording.addEventListener('click',function(ev){
            if(mediaRecorder.state=='paused'|| mediaRecorder.state=='recording')
                mediaRecorder.stop();
            else if(mediaRecorder.state=='inactive')alert('recording has not started yet!');
            console.log(mediaRecorder.state);

            let blob = new Blob(chunks, { 'type' : 'video/mp4;' });
            chunks = [];
            let videoURL = window.URL.createObjectURL(blob);
            vidSave.src = videoURL;
            console.log(videoURL)
        });
        mediaRecorder.ondataavailable = function(ev) {
            chunks.push(ev.data);
        }
        // mediaRecorder.onstop = (ev)=>{
            // let blob = new Blob(chunks, { 'type' : 'video/mp4;' });
            // chunks = [];
            // let videoURL = window.URL.createObjectURL(blob);
            // vidSave.src = videoURL;
            // console.log(videoURL)
        // }
        downloadRecording.addEventListener('click',function(ev){
            if(mediaRecorder.state=='paused'|| mediaRecorder.state=='recording'){
                let blob = new Blob(chunks, { 'type' : 'video/mp4;' });
                chunks = [];
                let videoURL = window.URL.createObjectURL(blob);
                vidSave.src = videoURL;
                console.log(videoURL)
            }
            else if(mediaRecorder.state=='inactive')
                alert('Either the recording has not started or stopped');
        });

    });
}