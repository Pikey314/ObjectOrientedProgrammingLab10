package prGuiJug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugController implements ActionListener {

    private JugView jugPanel;
    private Jug jugA;
    private Jug jugB;

    public JugController(JugView jugPanel){
        this.jugPanel = jugPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "INIT") {
            this.jugA = new Jug(this.jugPanel.getCapacityJugA());
            this.jugB = new Jug(this.jugPanel.getCapacityJugB());
            this.jugPanel.setJugACapacity(jugA.getCapacity());
            this.jugPanel.setJugBCapacity(jugB.getCapacity());

            this.jugPanel.enableSetting(false);
            this.jugPanel.ok("Jugs initialized");
            this.jugPanel.addMessage2History("Jugs initialized");
        } else if (e.getActionCommand() == "END") {
            this.jugPanel.clearHistory();
            this.jugPanel.enableSetting(true);
            this.jugPanel.ok("Ending execution for those Jugs");
            this.jugPanel.addMessage2History("Ending execution for those Jugs");
        } else if (e.getActionCommand() == "FILL_A") {
            if (this.jugA.getContent() == this.jugA.getCapacity())
                this.jugPanel.error("Jug A already full");
            else {
                this.jugA.fill();
                this.jugPanel.setJugAContent(this.jugA.getContent());
                this.jugPanel.addMessage2History("Filling Jug A");
                this.jugPanel.ok("Filling JugA");
            }
        } else if (e.getActionCommand() == "FILL_B") {
            if (this.jugB.getContent() == this.jugB.getCapacity())
                this.jugPanel.error("Jug B already full");
            else {
                this.jugB.fill();
                this.jugPanel.setJugBContent(this.jugB.getContent());
                this.jugPanel.addMessage2History("Filling Jug B");
                this.jugPanel.ok("Filling JugB");
            }
        } else if (e.getActionCommand() == "EMPTY_B") {
            if (this.jugB.getContent() == 0)
                this.jugPanel.error("Jug B already empty");
            else {
                this.jugB.empty();
                this.jugPanel.setJugBContent(this.jugB.getContent());
                this.jugPanel.addMessage2History("Emptying Jug B");
                this.jugPanel.ok("Emptying JugB");
            }
        } else if (e.getActionCommand() == "EMPTY_A") {
            if (this.jugA.getContent() == 0)
                this.jugPanel.error("Jug A already empty");
            else {
                this.jugA.empty();
                this.jugPanel.setJugAContent(this.jugA.getContent());
                this.jugPanel.addMessage2History("Emptying Jug A");
                this.jugPanel.ok("Emptying JugA");
            }
        } else if (e.getActionCommand() == "POUR_A2B") {
            if (this.jugA.getContent()==0 || this.jugB.getCapacity()== this.jugB.getContent())
                this.jugPanel.error("Can't pour watter!");
            else {
                this.jugB.pourFrom(this.jugA);
                this.jugPanel.setJugAContent(this.jugA.getContent());
                this.jugPanel.setJugBContent(this.jugB.getContent());
                this.jugPanel.addMessage2History("Pouring from Jug A to Jug B");
                this.jugPanel.ok("Pouring");
            }

        } else if (e.getActionCommand() == "POUR_B2A") {
            if (this.jugB.getContent()==0 || this.jugA.getCapacity()== this.jugA.getContent())
                this.jugPanel.error("Can't pour watter!");
            else {
                this.jugA.pourFrom(this.jugB);
                this.jugPanel.setJugAContent(this.jugA.getContent());
                this.jugPanel.setJugBContent(this.jugB.getContent());
                this.jugPanel.addMessage2History("Pouring from Jug B to Jug A");
                this.jugPanel.ok("Pouring");
            }

        }
    }
}
