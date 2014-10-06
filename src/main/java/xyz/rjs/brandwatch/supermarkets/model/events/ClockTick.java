package xyz.rjs.brandwatch.supermarkets.model.events;

public class ClockTick {
    private int tick;

    public ClockTick(int tick) {
        this.tick = tick;
    }

    public int getTick() {
        return tick;
    }

    @Override
    public String toString() {
        return "ClockTick{" +
                "tick=" + tick +
                '}';
    }
}
