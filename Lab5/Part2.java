package Lab5;

// The target interface, representing the desired interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// An existing class w/ different interface
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter class which makes the incompatible interface compatible
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        // Create the appropriate player based on the audio type
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = new AdvancedMediaPlayer();         
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new AdvancedMediaPlayer();
        }   
    }

    @Override
    public void play(String audioType, String fileName) {
        // Call method based on audio type
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Client class that uses the adapter
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter; 

    @Override
    public void play(String audioType, String fileName) {
        // Adapter is used when the audio type is vlc or mp4
        if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }   

    // Main
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp4", "beyond_the_horizon.mp4");
        audioPlayer.play("vlc", "far_far_away.vlc");
        audioPlayer.play("avi", "mind_me.avi"); // Unsupported format
    }
}
