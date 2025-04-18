import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel0;

    private Font l1 = new Font("Arial", Font.PLAIN, 30);
    private Font l2 = new Font("Arial", Font.PLAIN, 50);
    private Font l3 = new Font("Arial", Font.PLAIN, 60);
    private Font l3_5 = new Font("Arial", Font.PLAIN, 120);
    private Font l4 = new Font("Arial", Font.PLAIN, 150);
    private Font cu1 = new Font("Arial", Font.BOLD, 20);
    private Font cu2 = new Font("Arial", Font.BOLD, 30);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().initialize());
    }

    private void initialize() {
        frame = new JFrame("Cafe Menu");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        cardLayout = new CardLayout();
        mainPanel0 = new JPanel(cardLayout);


        mainPanel0.add(createMainPanel(), "mainPanel");
        mainPanel0.add(createFoodPanel(), "foodPanel");
        mainPanel0.add(createDessertPanel(), "dessertPanel");
        mainPanel0.add(createDrinkPanel(), "drinkPanel");
        mainPanel0.add(createCashPanel(), "cashPanel");


        cardLayout.show(mainPanel0, "mainPanel");


        frame.add(mainPanel0);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 20, 20));


        ImageIcon foodIcon = new ImageIcon("menucafe/menu/food.png");
        ImageIcon dessertIcon = new ImageIcon("menucafe/menu/des.png");
        ImageIcon drinkIcon = new ImageIcon("menucafe/menu/drink.png");
        ImageIcon cashIcon = new ImageIcon("menucafe/menu/money.png");


        JButton buttonFood = createButton(foodIcon, e -> cardLayout.show(mainPanel0, "foodPanel"));
        JButton buttonDessert = createButton(dessertIcon, e -> cardLayout.show(mainPanel0, "dessertPanel"));
        JButton buttonDrink = createButton(drinkIcon, e -> cardLayout.show(mainPanel0, "drinkPanel"));
        JButton buttonCash = createButton(cashIcon, e -> cardLayout.show(mainPanel0, "cashPanel"));


        mainPanel.add(buttonFood);
        mainPanel.add(buttonDessert);
        mainPanel.add(buttonDrink);
        mainPanel.add(buttonCash);

        return mainPanel;
    }

    private JButton createButton(ImageIcon icon, ActionListener listener) {
        JButton button = new JButton(icon);
        button.addActionListener(listener);
        return button;
    }

    private JPanel createFoodPanel() {
        JPanel foodPanel = new JPanel(null);

        addMenuItem(foodPanel, "Pizza:", "400.000", 10, 10, 700, 50);
        addMenuItem(foodPanel, "Pasta:", "350.000", 10, 210, 700, 250);
        addMenuItem(foodPanel, "Burger:", "300.000", 10, 410, 700, 450);

        addBackButton(foodPanel, e -> cardLayout.show(mainPanel0, "mainPanel"));

        return foodPanel;
    }

    private JPanel createDessertPanel() {
        JPanel dessertPanel = new JPanel(null);

        addMenuItem(dessertPanel, "Cheesecake:", "100.000", 10, 10, 700, 50);
        addMenuItem(dessertPanel, "Carrotcake:", "80.000", 10, 210, 700, 250);
        addMenuItem(dessertPanel, "Chocolatecake:", "75.000", 10, 410, 700, 450);

        addBackButton(dessertPanel, e -> cardLayout.show(mainPanel0, "mainPanel"));

        return dessertPanel;
    }

    private JPanel createDrinkPanel() {
        JPanel drinkPanel = new JPanel(null);


        addMenuItem(drinkPanel, "Masalatea:", "80.000", 10, 10, 700, 50);
        addMenuItem(drinkPanel, "Cappuccino:", "50.000", 10, 210, 700, 250);
        addMenuItem(drinkPanel, "Latte:", "65.000", 10, 410, 700, 450);


        addBackButton(drinkPanel, e -> cardLayout.show(mainPanel0, "mainPanel"));

        return drinkPanel;
    }

    private JPanel createCashPanel() {
        JPanel cashPanel = new JPanel(null);

        return cashPanel;
    }

    private void addMenuItem(JPanel panel, String name, String price, int x1, int y1, int x2, int y2) {
        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(x1, y1, 450, 150);
        nameLabel.setFont(l3);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setBounds(x1 + 440, y1, 400, 150);
        priceLabel.setFont(l2);


        panel.add(nameLabel);
        panel.add(priceLabel);
    }

    private void addBackButton(JPanel panel, ActionListener listener) {
        JButton backButton = new JButton("Back to Menu");
        backButton.setBounds(600, 580, 350, 170);
        backButton.setFont(cu2);
        backButton.setForeground(Color.RED);
        backButton.addActionListener(listener);
        panel.add(backButton);
    }
}