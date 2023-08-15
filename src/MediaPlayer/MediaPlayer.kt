package MediaPlayer
class MediaPlayer {
    val mediaPlayer = MediaPlayer.create(context, R.audio.coins27-36030.mp3) // Ersetze "sound_effect" durch den Dateinamen deines Soundeffekts in res/raw
    val audioAttributes = AudioAttributesCompat.Builder()
        .setUsage(USAGE_GAME)
        .setContentType(CONTENT_TYPE_SONIFICATION)
        .build()

    mediaPlayer.setAudioAttributes(audioAttributes)
}
