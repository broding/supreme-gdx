package nl.basroding.supreme;

public interface IContext {
    void initialize();
    void addView(IView view);
    void removeView(IView view);
    void destroyViews();
}
