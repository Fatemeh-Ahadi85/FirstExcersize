package FirstExersize;

abstract class findPairs {
    public abstract int getPairs();
    protected String input;

    public findPairs(String input) {
        this.input = input;
    }
    public int pairs(){
        return getPairs();
    }
}
