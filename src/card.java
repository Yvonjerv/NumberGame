import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

public class card {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    card window = new card();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public card() {
        initialize();
    }

    /**
     * Initialise the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(153, 204, 255));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(127, 11, 219, 104);
        frame.getContentPane().add(lblLogo);
        lblLogo.setIcon(new ImageIcon("Images\\zlogoimg.png")); 

        JLabel lblNewLabel = new JLabel("t: 01254 777494");
        lblNewLabel.setFont(new Font("Source Code Pro Light", Font.PLAIN, 11));
        lblNewLabel.setBounds(20, 187, 126, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblEApexuxdesigngmailcom = new JLabel("e: apexuxdesign@gmail.com");
        lblEApexuxdesigngmailcom.setFont(new Font("Source Code Pro Light", Font.PLAIN, 11));
        lblEApexuxdesigngmailcom.setBounds(20, 204, 200, 14);
        frame.getContentPane().add(lblEApexuxdesigngmailcom);

        JLabel lblVisitWebsite = new JLabel("visit website");
        lblVisitWebsite.setFont(new Font("Source Code Pro Light", Font.BOLD, 11));
        lblVisitWebsite.setBounds(10, 237, 117, 14);
        frame.getContentPane().add(lblVisitWebsite);

        JLabel facebook = new JLabel("");
        facebook.setBounds(282, 204, 64, 47);
        frame.getContentPane().add(facebook);
        facebook.setIcon(new ImageIcon("Images\\facebook.png"));

        JLabel twitter = new JLabel("");
        twitter.setBounds(320, 204, 72, 47);
        frame.getContentPane().add(twitter);
        twitter.setIcon(new ImageIcon("Images\\twitter.png"));

        JLabel youtube = new JLabel("");
        youtube.setBounds(356, 204, 68, 47);
        frame.getContentPane().add(youtube);
        youtube.setIcon(new ImageIcon("Images\\youtube.png"));

        JLabel lblSeanHutchinson = new JLabel("Sean Hutchinson");
        lblSeanHutchinson.setFont(new Font("Source Code Pro Light", Font.PLAIN, 11));
        lblSeanHutchinson.setBounds(20, 128, 126, 14);
        frame.getContentPane().add(lblSeanHutchinson);

        JLabel lblUxDesigner = new JLabel("UX Designer");
        lblUxDesigner.setFont(new Font("Source Code Pro Light", Font.PLAIN, 11));
        lblUxDesigner.setBounds(20, 145, 107, 14);
        frame.getContentPane().add(lblUxDesigner);

    JLabel lblNewLabel_1 = new JLabel("CEO - Apex UX Design");
        lblNewLabel_1.setFont(new Font("Source Code Pro Light", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(20, 162, 158, 14);
        frame.getContentPane().add(lblNewLabel_1);


    }
}