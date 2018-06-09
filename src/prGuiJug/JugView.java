package prGuiJug;
import java.awt.event.ActionListener;

public interface JugView 
{
	public static final String GO = "INIT";
	public static final String FILL_A = "FILL_A";
	public static final String FILL_B = "FILL_B";
	public static final String EMPTY_A = "EMPTY_A";
	public static final String EMPTY_B = "EMPTY_B";
	public static final String POUR_A2B = "POUR_A2B";
	public static final String POUR_B2A = "POUR_B2A";
	public static final String END = "END";


	public void controller(ActionListener ctr);
	public int getCapacityJugA();
	public int getCapacityJugB();
	
	/**
	 * Show error message
	 */
	public void error(String msg);

	/**
	 * Show OK message
	 */
	public void ok(String msg);

	/**
	 * Enable or disable initialization
	 * 
	 * @param b
	 *            true enable initialization setting
	 */
	public void enableSetting(boolean b);
	public void setJugACapacity(int c);
	public void setJugBCapacity(int c);
	public void setJugAContent(int c);
	public void setJugBContent(int c);

	/**
	 * Add a message to message history
	 * 
	 */
	public void addMessage2History(String msg);
	public void clearHistory();
}