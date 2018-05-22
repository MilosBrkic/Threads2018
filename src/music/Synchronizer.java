/*
 * Created on May 10, 2018
 *
 */
package music;

import gui.GUIKontroler;

public class Synchronizer {
    
    public int voiceFlag = 1;
    private boolean first;
    private boolean second;
    private boolean third;
    private boolean stop = false;  
    
    public void setFirst(boolean first) {
		this.first = first;
		if(!second && !third)
			voiceFlag = 1;
	}


	public void setSecond(boolean second) {
		this.second = second;
		if(!first && !third)
			voiceFlag = 2;
	}


	public void setThird(boolean third) {
		this.third = third;
		if(!second && !first)
			voiceFlag = 3;
	}
	
	public boolean isFirst() {
		return first;
	}


	public boolean isSecond() {
		return second;
	}


	public boolean isThird() {
		return third;
	}

	public void stop() {
		stop = true;
	}
	
	public void startAll() {
		//voiceFlag = 1;
		first = true;
		second = true;
		third = true;
	}


	public synchronized void singFirstVoice(String lyrics, int delay, String name) {
        while (voiceFlag!=1) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        sing(lyrics, delay, name);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay, String name) {
        while (voiceFlag!=2) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay, name);
    }
    
    public synchronized void singBackgroundVoice(String lyrics, int delay, String name) {
        while (voiceFlag!=3) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay, name);
    }
    
    
    private void sing(String lyrics, int delay, String name) {
        if(!stop)
        	GUIKontroler.ispis(lyrics, name);
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        switching(); 
    }
    
    private void switching() {
    	if(voiceFlag==1) {
    		if(second)
    			voiceFlag=2;
    		else if(third)
    			voiceFlag=3;
    		
    		notifyAll();
    		return;
    	}
    	
    	if(voiceFlag==2) {
    		if(third)
    			voiceFlag=3;
    		else if(first)
    			voiceFlag=1;
    		
    		notifyAll();
    		return;
    	}
    	
    	if(voiceFlag==3) {
    		if(first)
    			voiceFlag=1;
    		else if(second)
    			voiceFlag=2;
    		
    		notifyAll();
    		return;
    	}
    	
    }
}	
