package GUI;

import javax.swing.*;
import java.awt.*;

public class BrowserSessionGUI {

    private JFrame frame;
    private JList<String> sessionHistoryList;
    private JList<String> lruList;
    private JTabbedPane tabbedPane;

    public BrowserSessionGUI() {
        initializeFrame();
        createMenuBar();
        createLeftPanel();
        createCenterPanel();
        createBottomPanel();

        frame.setVisible(true);
    }

    // ---------------- FRAME ----------------
    private void initializeFrame() {
        frame = new JFrame("Browser Session & LRU Tab Manager");
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ---------------- MENU BAR ----------------
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveSession = new JMenuItem("Save Session");
        JMenuItem restoreSession = new JMenuItem("Restore Session");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(saveSession);
        fileMenu.add(restoreSession);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    // ---------------- LEFT PANEL ----------------
    private void createLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(220, 0));

        JLabel label = new JLabel("Session History", JLabel.CENTER);

        // Dummy session data
        String[] sessions = {
                "Session 1 - Morning",
                "Session 2 - Afternoon",
                "Session 3 - Evening"
        };

        sessionHistoryList = new JList<>(sessions);
        JScrollPane scrollPane = new JScrollPane(sessionHistoryList);

        leftPanel.add(label, BorderLayout.NORTH);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(leftPanel, BorderLayout.WEST);
    }

    // ---------------- CENTER PANEL ----------------
    private void createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());

        tabbedPane = new JTabbedPane();

        // Dummy tabs
        tabbedPane.addTab("Google", new JLabel("Google Page"));
        tabbedPane.addTab("YouTube", new JLabel("YouTube Page"));
        tabbedPane.addTab("GitHub", new JLabel("GitHub Page"));

        // Control Buttons
        JPanel controlPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton openTab = new JButton("Open Tab");
        JButton closeTab = new JButton("Close Tab");
        JButton accessTab = new JButton("Access Tab");

        controlPanel.add(openTab);
        controlPanel.add(closeTab);
        controlPanel.add(accessTab);

        centerPanel.add(tabbedPane, BorderLayout.CENTER);
        centerPanel.add(controlPanel, BorderLayout.EAST);

        frame.add(centerPanel, BorderLayout.CENTER);
    }

    // ---------------- BOTTOM PANEL ----------------
    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(0, 120));

        JLabel label = new JLabel("LRU Cache Status", JLabel.CENTER);

        // Dummy LRU data
        String[] lruTabs = {
                "YouTube",
                "Google",
                "GitHub"
        };

        lruList = new JList<>(lruTabs);
        JScrollPane scrollPane = new JScrollPane(lruList);

        bottomPanel.add(label, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BrowserSessionGUI::new);
    }
}
