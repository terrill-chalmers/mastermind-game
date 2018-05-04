package domain;

public class ColorTotals {

    public ColorTotals() {
        this.blackPegs = 0;
        this.whitePegs = 0;
        this.redPegs = 0;
        this.bluePegs = 0;
        this.greenPegs = 0;
        this.yellowPegs = 0;
    }

    int blackPegs, whitePegs, redPegs, bluePegs, greenPegs, yellowPegs;

    public int getBlackPegs() { return blackPegs; }

    public void setBlackPegs(int blackPegs) { this.blackPegs = blackPegs; }

    public int getWhitePegs() { return whitePegs; }

    public void setWhitePegs(int whitePegs) { this.whitePegs = whitePegs; }

    public int getRedPegs() { return redPegs; }

    public void setRedPegs(int redPegs) { this.redPegs = redPegs; }

    public int getBluePegs() { return bluePegs; }

    public void setBluePegs(int bluePegs) { this.bluePegs = bluePegs; }

    public int getGreenPegs() { return greenPegs; }

    public void setGreenPegs(int greenPegs) { this.greenPegs = greenPegs; }

    public int getYellowPegs() { return yellowPegs; }

    public void setYellowPegs(int yellowPegs) { this.yellowPegs = yellowPegs; }

    public void incrementColor(Peg peg) {
        if(peg == Peg.BLACK) {
            this.setBlackPegs(this.getBlackPegs()+1);
        } else if(peg == Peg.WHITE) {
            this.setWhitePegs(this.getWhitePegs()+1);
        } else if(peg == Peg.RED) {
            this.setRedPegs(this.getRedPegs()+1);
        }else if(peg == Peg.BLUE) {
            this.setBluePegs(this.getBluePegs()+1);
        }else if(peg == Peg.GREEN) {
            this.setGreenPegs(this.getGreenPegs()+1);
        }else if(peg == Peg.YELLOW) {
            this.setYellowPegs(this.getYellowPegs()+1);
        }
    }
}
