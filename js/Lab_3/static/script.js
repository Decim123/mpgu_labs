let sound
let isInitialised = false
let amplitude
let fft
const tracks = [
    { src: '/static/audio/track1.mp3', image: '/static/images/image1.jpg', color: 'rgba(43, 43, 43, 0.9)' },
    { src: '/static/audio/track2.mp3', image: '/static/images/image2.jpg', color: 'rgba(59, 59, 59, 0.9)' },
    { src: '/static/audio/track3.mp3', image: '/static/images/image3.jpg', color: 'rgba(75, 75, 75, 0.9)' }
]
let currentTrack = 0
let isPlaying = false

function preload() {
    console.log("Preload called")
    sound = loadSound(tracks[currentTrack].src, () => {
        console.log("Audio loaded")
        isInitialised = true
    }, (err) => {
        console.error("Ошибка загрузки аудио:", err)
    })
    sound.setVolume(0.5)
}

function setup() {
    console.log("Setup called")
    let canvas = createCanvas(400, 150)
    canvas.parent('visualizer-container')
    colorMode(HSB, 360, 100, 100)
    amplitude = new p5.Amplitude()
    fft = new p5.FFT()
}

function draw() {
    background(0)
    if (sound.isPlaying()) {
        console.log("Sound is playing")
        let level = amplitude.getLevel()
        let spectrum = fft.analyze()
        let bass = fft.getEnergy("bass")
        let lowMid = fft.getEnergy("lowMid")
        let mid = fft.getEnergy("mid")
        let highMid = fft.getEnergy("highMid")
        let treble = fft.getEnergy("treble")
        fill(255)
        textSize(12)
        text("Volume: " + nf(level,1,3), 10, 15)
        text("Bass: " + bass, 10, 30)
        text("LowMid: " + lowMid, 10, 45)
        text("Mid: " + mid, 10, 60)
        text("HighMid: " + highMid, 10, 75)
        text("Treble: " + treble, 10, 90)
        noStroke()
        let w = width / spectrum.length
        for (let i = 0; i < spectrum.length; i++) {
            let h = map(spectrum[i], 0, 255, 0, height - 100)
            fill(map(i, 0, spectrum.length, 0, 360), 100, 100)
            rect(i*w, height - h, w, h)
        }
    }
}

document.getElementById('play-pause').addEventListener('click', () => {
    const box = document.getElementById('box')
    box.classList.remove('jump-down','move-left','move-right')
    const playPauseBtn = document.getElementById('play-pause')
    if (!isPlaying) {
        box.classList.add('jump-up')
        playPauseBtn.innerHTML = '<i class="bi bi-pause-fill"></i>'
        if (!isInitialised) {
            sound.loop()
            isInitialised = true
        } else {
            sound.play()
        }
    } else {
        box.classList.add('jump-down')
        playPauseBtn.innerHTML = '<i class="bi bi-play-fill"></i>'
        sound.pause()
    }
    isPlaying = !isPlaying
    box.addEventListener('animationend', () => {
        box.classList.remove('jump-up','jump-down')
    }, { once: true })
})

document.getElementById('next').addEventListener('click', () => {
    const box = document.getElementById('box')
    box.classList.remove('jump-up','jump-down','move-left')
    box.classList.add('move-right')
    currentTrack = (currentTrack + 1) % tracks.length
    updateTrack()
    box.addEventListener('animationend', () => {
        box.classList.remove('move-right')
    }, { once: true })
})

document.getElementById('prev').addEventListener('click', () => {
    const box = document.getElementById('box')
    box.classList.remove('jump-up','jump-down','move-right')
    box.classList.add('move-left')
    currentTrack = (currentTrack - 1 + tracks.length) % tracks.length
    updateTrack()
    box.addEventListener('animationend', () => {
        box.classList.remove('move-left')
    }, { once: true })
})

function updateTrack() {
    if (sound.isPlaying() || isPlaying) {
        sound.stop()
    }
    sound = loadSound(tracks[currentTrack].src, () => {
        if (isPlaying) {
            sound.loop()
        }
    }, (err) => {
        console.error("Ошибка загрузки аудио:", err)
    })
    document.getElementById('track-image').src = tracks[currentTrack].image
    document.getElementById('box').style.backgroundColor = tracks[currentTrack].color
}
