package test;


import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {
  
    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer background;
    private Synchronizer synch;
    private boolean start = true;
    
    public void initializeSingingInThreads() {
        String lyrics1 = "Because the night";
        String lyrics2 = "Belongs to lovers";
        String lyrics3 = "..lovers...";
        
        boolean stopIt = false;
        synch = new Synchronizer();
        
        Performance firstVoicePerformance = new Performance(lyrics1, 1500);
        Performance secondVoicePerformance = new Performance(lyrics2, 1500);
        Performance backVoicePerformance = new Performance(lyrics3, 1500);
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
        background = new Singer("Background voice", Voice.BACKGROUND, backVoicePerformance, stopIt, synch);
    }
    
   
    public void start(boolean first, boolean second, boolean back) {
    	if(start) {
    		initializeSingingInThreads();
    		start = false;
    	}
    	if(first && !synch.isFirst()) {
    		synch.setFirst(true);
    		pattiSmith.start();
    	}
    	if(second && !synch.isSecond()) {
    		synch.setSecond(true);
    		bruceSpringsteen.start();
    	}
    	if(back && !synch.isThird()) {
    		synch.setThird(true);
    		background.start();
    	}
    }  
    
    public void stop() {
    	synch.stop();
    	pattiSmith.setStopIt(true);
        bruceSpringsteen.setStopIt(true);
        background.setStopIt(true);
        start = true;
    }  
    
}

