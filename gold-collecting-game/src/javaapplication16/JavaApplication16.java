/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class JavaApplication16 extends JFrame {

    static boolean buttona_Bas = true;

    public JavaApplication16(String title) throws HeadlessException {
        super(title);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {

        NewJFrame ayarlar = new NewJFrame();
        ayarlar.setLayout(null);
        ayarlar.setVisible(true);
        while (ayarlar.baslat_Bas) {

        }

        TimeUnit.SECONDS.sleep(1);
        ayarlar.setVisible(false);

        JFrame f = new JFrame("Button Example");
        JButton b = new JButton("Next");
        JButton bitir = new JButton("bitir");
        bitir.setBounds(300, 300, 95, 30);
        b.setBounds(50, 100, 95, 30);
        /*JTextField text=new JTextField("Next");
        text.setBounds(40, 40, 300, 300);
        f.add(text);*/
        f.add(bitir);
        f.add(b);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttona_Bas = false;

            }
        });
        

          File file=new File("dosya.txt");
        if(file.exists()){
            file.createNewFile();
        }
        FileWriter fWriter=new FileWriter(file,false);
        BufferedWriter bWriter=new BufferedWriter(fWriter);
        
        
         bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(JavaApplication16.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        
        
        int player_altin_sayisi = ayarlar.getBaslangicAltini();//VARSAYILAN
        int altin_orani = ayarlar.getAltinOrani();//VARSAYILAN
        int gizli_altin_orani = ayarlar.getGizliAltinOrani();//VARSAYILAN
        int satir_sayisi = ayarlar.getSatir();//VARSAYILAN
        int sutun_sayisi = ayarlar.getSutun();//VARSAYILAN
        int kare_sayisi = sutun_sayisi * satir_sayisi;
        int[][] harita = new int[satir_sayisi][sutun_sayisi];
        int toplam_altin_sayisi = (kare_sayisi * altin_orani) / 100;
        int gizli_altin_sayisi = (toplam_altin_sayisi * gizli_altin_orani) / 100;
        int gorunen_altin_sayisi = toplam_altin_sayisi - gizli_altin_sayisi;
        Random r = new Random(); //random sınıfı
        Scanner scanner = new Scanner(System.in);
        int bir_hamlede_kac_kare = ayarlar.getHamleBasinaMaxAdimSayisi();//VARSAYILAN
        int c_gorulen_gizli_altin = ayarlar.getC_acabildigiGizliAltinSayisi();//VARSAYILAN

        int harcanan_toplam_altin_A = 0;
        int toplanan_toplam_altin_A = 0;
        int atilan_adim_sayisi_A = 0;
        boolean A_Hedef_belirledi = false;
        int Player_A_x = 0;
        int Player_A_y = 0;
        int bir_adimda_atlanacak_kare_A = bir_hamlede_kac_kare;
        int Player_A_Altin = player_altin_sayisi;
        int Player_A_Hamle_maaliyet = ayarlar.getA_hamleMaliyeti();//VARSAYILAN
        int Player_A_Hedef_maaliyet = ayarlar.getA_hedefMaliyeti();//VARSAYILAN
        int A_sira = 1;
        int A_elendi_mi = 0;
        int toplam_A = 0;
        Koordinat en_yakin_koordinat_A = new Koordinat();
        ArrayList<Integer> mesafeler_A = new ArrayList<Integer>();
        ArrayList<Koordinat> koordinatlar_A = new ArrayList<Koordinat>();
        //////////////////////////////////////////////////////////////////////////
        int harcanan_toplam_altin_B = 0;
        int toplanan_toplam_altin_B = 0;
        int atilan_adim_sayisi_B = 0;
        boolean B_Hedef_belirledi = false;
        int Player_B_x = 0;
        int Player_B_y = sutun_sayisi - 1;
        int bir_adimda_atlanacak_kare_B = bir_hamlede_kac_kare;
        int Player_B_Altin = player_altin_sayisi;
        int Player_B_Hamle_maaliyet = ayarlar.getB_hamleMaliyeti();//VARSAYILAN
        int Player_B_Hedef_maaliyet = ayarlar.getB_hedefMaliyeti();//VARSAYILAN
        int toplam_B = 0;
        Koordinat en_yakin_koordinat_B = new Koordinat();
        ArrayList<Integer> mesafeler_B = new ArrayList<Integer>();
        ArrayList<Koordinat> koordinatlar_B = new ArrayList<Koordinat>();
        int B_sira = 0;
        int B_elendi_mi = 0;
        //////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        int harcanan_toplam_altin_C = 0;
        int toplanan_toplam_altin_C = 0;
        int atilan_adim_sayisi_C = 0;
        boolean C_Hedef_belirledi = false;
        int Player_C_x = satir_sayisi - 1;
        int Player_C_y = 0;
        int bir_adimda_atlanacak_kare_C = bir_hamlede_kac_kare;
        int Player_C_Altin = player_altin_sayisi;
        int Player_C_Hamle_maaliyet = ayarlar.getC_hamleMaliyeti();//VARSAYILAN
        int Player_C_Hedef_maaliyet = ayarlar.getC_hedefMaliyeti();//VARSAYILAN
        int toplam_C = 0;
        Koordinat en_yakin_koordinat_C = new Koordinat();
        ArrayList<Integer> mesafeler_C = new ArrayList<Integer>();
        ArrayList<Koordinat> koordinatlar_C = new ArrayList<Koordinat>();
        int C_sira = 0;
        int C_elendi_mi = 0;
        int C_kac_tane_gizli_altini_gorsun = c_gorulen_gizli_altin;
        //en yakin gizlileri bulmak icin
        ArrayList<Integer> mesafeler_C_ozel = new ArrayList<Integer>();
        ArrayList<Koordinat> koordinatlar_C_ozel = new ArrayList<Koordinat>();
        int toplam_C_ozel = 0;
        //////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        int harcanan_toplam_altin_D = 0;
        int toplanan_toplam_altin_D = 0;
        int atilan_adim_sayisi_D = 0;
        boolean D_Hedef_belirledi = false;
        int Player_D_x = satir_sayisi - 1;
        int Player_D_y = sutun_sayisi - 1;
        int bir_adimda_atlanacak_kare_D = bir_hamlede_kac_kare;
        int Player_D_Altin = player_altin_sayisi;
        int Player_D_Hamle_maaliyet = ayarlar.getD_hamleMaliyeti();//VARSAYILAN
        int Player_D_Hedef_maaliyet = ayarlar.getD_hedefmaliyeti();//VARSAYILAN
        int toplam_D = 0;
        Koordinat en_yakin_koordinat_D = new Koordinat();
        ArrayList<Integer> mesafeler_D = new ArrayList<Integer>();
        ArrayList<Koordinat> koordinatlar_D = new ArrayList<Koordinat>();
        int D_sira = 0;
        int D_elendi_mi = 0;
        //////////////////////////////////////////////////////////////////////

        //matrisi olusturma
        for (int i = 0; i < harita.length; i++) {
            for (int j = 0; j < harita[0].length; j++) {
                harita[i][j] = 0;

            }

        }

        //Gizli altinlari matrise isleme
        for (int i = 0; i < gizli_altin_sayisi; i++) {
            int x = r.nextInt(satir_sayisi);
            int y = r.nextInt(sutun_sayisi);
            harita[x][y] = -5 * r.nextInt(5);
        }
        System.out.println("\n\n");
        //gorunen altinlari matrise isleme
        for (int i = 0; i < gorunen_altin_sayisi; i++) {
            int x = r.nextInt(satir_sayisi);
            int y = r.nextInt(sutun_sayisi);
            harita[x][y] = 5 * r.nextInt(5);
        }

        JavaApplication16 ekran = new JavaApplication16("ALTIN OYUNU");
        GrafikKullanimi grafik = new GrafikKullanimi(harita);

        ekran.setVisible(true);
        ekran.setResizable(true);
        ekran.setSize(900, 800);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekran.add(grafik);

        harita[Player_A_x][Player_A_y] = 21;
        en_yakin_koordinat_A.x = Player_A_x;
        en_yakin_koordinat_A.y = Player_A_y;
        harita[Player_B_x][Player_B_y] = 22;
        en_yakin_koordinat_B.x = Player_B_x;
        en_yakin_koordinat_B.y = Player_B_y;
        harita[Player_C_x][Player_C_y] = 23;
        en_yakin_koordinat_C.x = Player_C_x;
        en_yakin_koordinat_C.y = Player_C_y;
        harita[Player_D_x][Player_D_y] = 24;
        en_yakin_koordinat_D.x = Player_D_x;
        en_yakin_koordinat_D.y = Player_D_y;
        TimeUnit.SECONDS.sleep(1);
        Yazdir(harita);
        grafik.harita = harita;
        grafik.repaint();
        TimeUnit.SECONDS.sleep(1);
        ///////////*/*//*/*//**/*/*/*/*/*/*//**/*/*/*/*/*////////////*/*//*/*//**/*/*/*/*/*/*//**/*/*/*/*/*/
        /////////*///////*/*/*/*//*/*/*/*/*/*/*/*/*//////////*///////*/*/*/*//*/*/*/*/*/*/*/*/*/

        while (oyun_devam(harita) && !(A_elendi_mi == 1 && B_elendi_mi == 1 && C_elendi_mi == 1 && D_elendi_mi == 1)) {
            if (A_sira == 1 && oyun_devam(harita)) {
                if (A_elendi_mi == 0) {
                    if (Player_A_Altin < Player_A_Hedef_maaliyet) {
                        System.out.println("hedef maaliyet=" + Player_A_Hedef_maaliyet + " A elendi hedef icin yetersiz altin sa altin=" + Player_A_Altin);
                        bWriter.write("hedef maaliyet=" + Player_A_Hedef_maaliyet + " A elendi hedef icin yetersiz altin sa altin=" + Player_A_Altin);
                        bWriter.write("\n");
                        A_elendi_mi = 1;
                        A_sira = 0;
                        B_sira = 1;
                        C_sira = 0;
                        D_sira = 0;
                    }

                    if (oyun_devam(harita) && !A_Hedef_belirledi(harita, en_yakin_koordinat_A.x, en_yakin_koordinat_A.y) && Player_A_Altin >= Player_A_Hedef_maaliyet && A_elendi_mi == 0) {

//Player A'ya gore altınların mesafesi ve koordinatlarını bulma
                        for (int i = 0; i < harita.length; i++) {
                            for (int j = 0; j < harita[0].length; j++) {
                                if (harita[i][j] > 0 && harita[i][j] < 21) {
                                    toplam_A = toplam_A + (Math.abs(Player_A_x - i)) + (Math.abs(Player_A_y - j));
                                    mesafeler_A.add(toplam_A);
                                    Koordinat koordinat_A = new Koordinat(i, j, toplam_A);
                                    koordinatlar_A.add(koordinat_A);
                                    toplam_A = 0;

                                }

                            }

                        }
                        //Player A'ya gore altinlarin mesafeleri ve koordinatları yazdirma
                        /*for (int i = 0; i < koordinatlar.size(); i++) {
                    System.out.println("x=" + koordinatlar.get(i).x + "y=" + koordinatlar.get(i).y + "mesafesi=" + koordinatlar.get(i).mesafe);
                }*/

                        //en yakın Altını secme algoritması
                        int temp = koordinatlar_A.get(0).mesafe;
                        en_yakin_koordinat_A.setX(koordinatlar_A.get(0).x);
                        en_yakin_koordinat_A.setY(koordinatlar_A.get(0).y);
                        en_yakin_koordinat_A.setMesafe(koordinatlar_A.get(0).mesafe);
                        for (int i = 0; i < koordinatlar_A.size(); i++) {
                            if (temp > koordinatlar_A.get(i).mesafe) {
                                temp = koordinatlar_A.get(i).mesafe;
                                en_yakin_koordinat_A.mesafe = koordinatlar_A.get(i).mesafe;
                                en_yakin_koordinat_A.x = koordinatlar_A.get(i).x;
                                en_yakin_koordinat_A.y = koordinatlar_A.get(i).y;

                            }

                        }

                        //TimeUnit.SECONDS.sleep(2);
                        System.out.println("Hedef Belirlendi...");
                        bWriter.write("Hedef Belirlendi...");
                        bWriter.write("\n");
                        System.out.println("en yakin nokta bilgileri\n" + " x=" + en_yakin_koordinat_A.x + " y=" + en_yakin_koordinat_A.y + " mesafesi=" + en_yakin_koordinat_A.mesafe);
                        bWriter.write("en yakin nokta bilgileri\n" + " x=" + en_yakin_koordinat_A.x + " y=" + en_yakin_koordinat_A.y + " mesafesi=" + en_yakin_koordinat_A.mesafe);
                        bWriter.write("\n");
                        mesafeler_A.clear();
                        koordinatlar_A.clear();
                        A_Hedef_belirledi = true;
                        Player_A_Altin = Player_A_Altin - Player_A_Hedef_maaliyet;
                        harcanan_toplam_altin_A = harcanan_toplam_altin_A + Player_A_Hedef_maaliyet;
                        System.out.println("Player A Hedef belirledi maaliyeti=" + Player_A_Hedef_maaliyet + "  Altin =" + Player_A_Altin);
                        bWriter.write("Player A Hedef belirledi maaliyeti=" + Player_A_Hedef_maaliyet + "  Altin =" + Player_A_Altin);
                        bWriter.write("\n");

                    }

                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    if (oyun_devam(harita) && A_Hedef_belirledi(harita, en_yakin_koordinat_A.x, en_yakin_koordinat_A.y) && Player_A_Altin >= Player_A_Hamle_maaliyet && A_elendi_mi == 0) {

                        int Player_A_adim_x = Player_A_x - en_yakin_koordinat_A.x;
                        int Player_A_adim_y = Player_A_y - en_yakin_koordinat_A.y;
                        for (int i = 0; i < Math.abs(Player_A_adim_x); i++) {
                            if (bir_adimda_atlanacak_kare_A > 0) {
                                if (Player_A_adim_x < 0) {
                                    bir_adimda_atlanacak_kare_A--;
                                    Player_A_x++;
                                    atilan_adim_sayisi_A++;
                                    if (harita[Player_A_x][Player_A_y] > 0 && harita[Player_A_x][Player_A_y] < 21) {//gorunur altin var mi
                                        Player_A_Altin = harita[Player_A_x][Player_A_y] + Player_A_Altin;
                                        toplanan_toplam_altin_A = toplanan_toplam_altin_A + harita[Player_A_x][Player_A_y];
                                        System.out.println("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("\n");
                                        harita[Player_A_x][Player_A_y] = 21;
                                        bir_adimda_atlanacak_kare_A = 0;
                                        A_Hedef_belirledi = false;
                                        System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_A_x && j == Player_A_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 21) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_A_x][Player_A_y] < 0) {
                                        harita[Player_A_x][Player_A_y] = harita[Player_A_x][Player_A_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_A_x][Player_A_y] == 0) {
                                        harita[Player_A_x][Player_A_y] = 21;

                                    }

                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_A_x && j == Player_A_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 21) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(3);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();

                                } else if (Player_A_adim_x > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_A--;
                                    Player_A_x--;
                                    atilan_adim_sayisi_A++;
                                    if (harita[Player_A_x][Player_A_y] > 0 && harita[Player_A_x][Player_A_y] < 21) {//gorunur altin var mi
                                        Player_A_Altin = harita[Player_A_x][Player_A_y] + Player_A_Altin;
                                        toplanan_toplam_altin_A = toplanan_toplam_altin_A + harita[Player_A_x][Player_A_y];
                                        System.out.println("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("\n");
                                        harita[Player_A_x][Player_A_y] = 21;
                                        bir_adimda_atlanacak_kare_A = 0;
                                        A_Hedef_belirledi = false;
                                        System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_A_x && j == Player_A_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 21) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_A_x][Player_A_y] < 0) {
                                        harita[Player_A_x][Player_A_y] = harita[Player_A_x][Player_A_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_A_x][Player_A_y] == 0) {
                                        harita[Player_A_x][Player_A_y] = 21;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_A_x && j == Player_A_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 21) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);
                                }

                            }

                        }
                        for (int i = 0; i < Math.abs(Player_A_adim_y); i++) {

                            if (bir_adimda_atlanacak_kare_A > 0) {

                                if (Player_A_adim_y < 0) {
                                    //TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_A--;
                                    Player_A_y++;
                                    atilan_adim_sayisi_A++;
                                    if (harita[Player_A_x][Player_A_y] > 0 && harita[Player_A_x][Player_A_y] < 21) {//gorunur altin var mi
                                        Player_A_Altin = harita[Player_A_x][Player_A_y] + Player_A_Altin;
                                        toplanan_toplam_altin_A = toplanan_toplam_altin_A + harita[Player_A_x][Player_A_y];
                                        System.out.println("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("\n");
                                        harita[Player_A_x][Player_A_y] = 21;
                                        bir_adimda_atlanacak_kare_A = 0;
                                        A_Hedef_belirledi = false;
                                        System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_A_x && j == Player_A_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 21) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_A_x][Player_A_y] < 0) {
                                        harita[Player_A_x][Player_A_y] = harita[Player_A_x][Player_A_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_A_x][Player_A_y] == 0) {
                                        harita[Player_A_x][Player_A_y] = 21;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_A_x && j == Player_A_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 21) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_A_adim_y > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_A--;
                                    Player_A_y--;
                                    atilan_adim_sayisi_A++;
                                    if (harita[Player_A_x][Player_A_y] > 0 && harita[Player_A_x][Player_A_y] < 21) {//gorunur altin var mi
                                        Player_A_Altin = harita[Player_A_x][Player_A_y] + Player_A_Altin;
                                        toplanan_toplam_altin_A = toplanan_toplam_altin_A + harita[Player_A_x][Player_A_y];
                                        System.out.println("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("player a nin altini arttirildi+" + harita[Player_A_x][Player_A_y] + " yeni altin=" + Player_A_Altin);
                                        bWriter.write("\n");
                                        harita[Player_A_x][Player_A_y] = 21;
                                        bir_adimda_atlanacak_kare_A = 0;
                                        A_Hedef_belirledi = false;
                                        System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_A_x && j == Player_A_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 21) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_A_x][Player_A_y] < 0) {
                                        harita[Player_A_x][Player_A_y] = harita[Player_A_x][Player_A_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_A_x][Player_A_y] == 0) {
                                        harita[Player_A_x][Player_A_y] = 21;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_A_x && j == Player_A_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 21) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("player A 'nin x=" + Player_A_x + " y= " + Player_A_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                }

                            }

                        }
                        if (bir_adimda_atlanacak_kare_A == 0) {
                            Player_A_Altin = Player_A_Altin - Player_A_Hamle_maaliyet;
                            harcanan_toplam_altin_A = harcanan_toplam_altin_A + Player_A_Hamle_maaliyet;
                            System.out.println("Player A hamle maaliyeti=" + Player_A_Hamle_maaliyet + " Altin=" + Player_A_Altin);
                            bWriter.write("Player A hamle maaliyeti=" + Player_A_Hamle_maaliyet + " Altin=" + Player_A_Altin);
                            bWriter.write("\n");
                            System.out.println("turun bitti bir sonraki tura geç");
                            bWriter.write("turun bitti bir sonraki tura geç");
                            bWriter.write("\n");
                            if (Player_A_Altin < Player_A_Hamle_maaliyet) {
                                System.out.println("Player A elendi .Altın=" + Player_A_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("Player A elendi .Altın=" + Player_A_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("\n");
                                A_elendi_mi = 1;
                                System.out.println("assss");
                                bir_adimda_atlanacak_kare_A = 0;

                            } else {
                                bir_adimda_atlanacak_kare_A = bir_hamlede_kac_kare;
                            }
                            A_sira = 0;
                            B_sira = 1;
                            C_sira = 0;
                            D_sira = 0;
                            while (buttona_Bas) {

                            }
                            buttona_Bas = true;
                            TimeUnit.SECONDS.sleep(1);
                        }

                    }
                }
            }
            A_sira = 0;
            B_sira = 1;
            C_sira = 0;
            D_sira = 0;
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB
            //BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB//BBBBBBBBB

            if (B_sira == 1 && oyun_devam(harita)) {

                if (B_elendi_mi == 0) {

                    if (Player_B_Altin < Player_B_Hedef_maaliyet) {
                        System.out.println("hedef maaliyet=" + Player_B_Hedef_maaliyet + " B elendi hedef icin yetersiz altin sa altin=" + Player_B_Altin);
                        bWriter.write("hedef maaliyet=" + Player_B_Hedef_maaliyet + " B elendi hedef icin yetersiz altin sa altin=" + Player_B_Altin);
                        bWriter.write("\n");
                        B_elendi_mi = 1;
                        A_sira = 0;
                        B_sira = 0;
                        C_sira = 1;
                        D_sira = 0;
                    }

                    if (oyun_devam(harita) && !B_Hedef_belirledi(harita, en_yakin_koordinat_B.x, en_yakin_koordinat_B.y) && Player_B_Altin >= Player_B_Hedef_maaliyet && B_elendi_mi == 0) {

//Player A'ya gore altınların mesafesi ve koordinatlarını bulma
                        for (int i = 0; i < harita.length; i++) {
                            for (int j = 0; j < harita[0].length; j++) {
                                if (harita[i][j] > 0 && harita[i][j] < 21) {
                                    toplam_B = toplam_B + (Math.abs(Player_B_x - i)) + (Math.abs(Player_B_y - j));
                                    mesafeler_B.add(toplam_B);
                                    Koordinat koordinat_B = new Koordinat(i, j, toplam_B);
                                    koordinatlar_B.add(koordinat_B);
                                    toplam_B = 0;

                                }

                            }

                        }
                        //Player B'ya gore altinlarin mesafeleri ve koordinatları yazdirma

                        /* for (int i = 0; i < koordinatlar_B.size(); i++) {
                    
                            System.out.println("x=" + koordinatlar_B.get(i).x + "y=" + koordinatlar_B.get(i).y + "mesafesi=" + koordinatlar_B.get(i).mesafe);
                }*/
                        //en yakın Altını secme algoritması
                        en_yakin_koordinat_B.setX(koordinatlar_B.get(0).x);
                        en_yakin_koordinat_B.setY(koordinatlar_B.get(0).y);
                        en_yakin_koordinat_B.setMesafe(koordinatlar_B.get(0).mesafe);
                        int kac_hamle_B = (int) Math.ceil((double) koordinatlar_B.get(0).mesafe / bir_adimda_atlanacak_kare_B);
                        int en_karli_B = harita[koordinatlar_B.get(0).x][koordinatlar_B.get(0).y] - (kac_hamle_B * Player_B_Hamle_maaliyet);
                        int temp = en_karli_B;
                        for (int i = 0; i < koordinatlar_B.size(); i++) {
                            kac_hamle_B = (int) Math.ceil((double) koordinatlar_B.get(i).mesafe / bir_adimda_atlanacak_kare_B);
                            en_karli_B = harita[koordinatlar_B.get(i).x][koordinatlar_B.get(i).y] - (kac_hamle_B * Player_B_Hamle_maaliyet);
                            if (temp < en_karli_B) {
                                temp = en_karli_B;
                                en_yakin_koordinat_B.mesafe = koordinatlar_B.get(i).mesafe;
                                en_yakin_koordinat_B.x = koordinatlar_B.get(i).x;
                                en_yakin_koordinat_B.y = koordinatlar_B.get(i).y;

                            }

                        }

                        //TimeUnit.SECONDS.sleep(2);
                        System.out.println("Hedef Belirlendi...");
                        bWriter.write("Hedef Belirlendi...");
                        bWriter.write("\n");
                        System.out.println("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_B.x + " y=" + en_yakin_koordinat_B.y + " mesafesi=" + en_yakin_koordinat_B.mesafe + " degeri= " + harita[en_yakin_koordinat_B.x][en_yakin_koordinat_B.y] + " kaari=" + temp);
                        bWriter.write("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_B.x + " y=" + en_yakin_koordinat_B.y + " mesafesi=" + en_yakin_koordinat_B.mesafe + " degeri= " + harita[en_yakin_koordinat_B.x][en_yakin_koordinat_B.y] + " kaari=" + temp);
                        bWriter.write("\n");
                        mesafeler_B.clear();
                        koordinatlar_B.clear();
                        B_Hedef_belirledi = true;
                        Player_B_Altin = Player_B_Altin - Player_B_Hedef_maaliyet;
                        harcanan_toplam_altin_B = harcanan_toplam_altin_B + Player_B_Hedef_maaliyet;
                        System.out.println("Player B Hedef belirledi maaliyeti=" + Player_B_Hedef_maaliyet + "  Altin =" + Player_B_Altin);
                        bWriter.write("Player B Hedef belirledi maaliyeti=" + Player_B_Hedef_maaliyet + "  Altin =" + Player_B_Altin);
                        bWriter.write("\n");

                    }

                    //HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB
                    //HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB
                    //HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB
                    //HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB//HAREKET ETME BBB
                    if (oyun_devam(harita) && B_elendi_mi == 0 && B_Hedef_belirledi(harita, en_yakin_koordinat_B.x, en_yakin_koordinat_B.y) && Player_B_Altin >= Player_B_Hamle_maaliyet) {

                        int Player_B_adim_x = Player_B_x - en_yakin_koordinat_B.x;
                        int Player_B_adim_y = Player_B_y - en_yakin_koordinat_B.y;
                        for (int i = 0; i < Math.abs(Player_B_adim_x); i++) {
                            if (bir_adimda_atlanacak_kare_B > 0) {
                                if (Player_B_adim_x < 0) {
                                    bir_adimda_atlanacak_kare_B--;
                                    Player_B_x++;
                                    atilan_adim_sayisi_B++;
                                    if (harita[Player_B_x][Player_B_y] > 0 && harita[Player_B_x][Player_B_y] < 21) {//gorunur altin var mi
                                        Player_B_Altin = harita[Player_B_x][Player_B_y] + Player_B_Altin;
                                        toplanan_toplam_altin_B = toplanan_toplam_altin_B + harita[Player_B_x][Player_B_y];
                                        System.out.println("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("\n");
                                        harita[Player_B_x][Player_B_y] = 22;
                                        bir_adimda_atlanacak_kare_B = 0;
                                        B_Hedef_belirledi = false;
                                        System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_B_x && j == Player_B_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 22) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_B_x][Player_B_y] < 0) {
                                        harita[Player_B_x][Player_B_y] = harita[Player_B_x][Player_B_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_B_x][Player_B_y] == 0) {
                                        harita[Player_B_x][Player_B_y] = 22;

                                    }

                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_B_x && j == Player_B_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 22) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_B_adim_x > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_B--;
                                    Player_B_x--;
                                    atilan_adim_sayisi_B++;
                                    if (harita[Player_B_x][Player_B_y] > 0 && harita[Player_B_x][Player_B_y] < 21) {//gorunur altin var mi
                                        Player_B_Altin = harita[Player_B_x][Player_B_y] + Player_B_Altin;
                                        toplanan_toplam_altin_B = toplanan_toplam_altin_B + harita[Player_B_x][Player_B_y];
                                        System.out.println("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("\n");
                                        harita[Player_B_x][Player_B_y] = 22;
                                        bir_adimda_atlanacak_kare_B = 0;
                                        B_Hedef_belirledi = false;
                                        System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_B_x && j == Player_B_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 22) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_B_x][Player_B_y] < 0) {
                                        harita[Player_B_x][Player_B_y] = harita[Player_B_x][Player_B_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_B_x][Player_B_y] == 0) {
                                        harita[Player_B_x][Player_B_y] = 22;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_B_x && j == Player_B_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 22) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);
                                }

                            }

                        }
                        for (int i = 0; i < Math.abs(Player_B_adim_y); i++) {

                            if (bir_adimda_atlanacak_kare_B > 0) {

                                if (Player_B_adim_y < 0) {
                                    //TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_B--;
                                    Player_B_y++;
                                    atilan_adim_sayisi_B++;
                                    if (harita[Player_B_x][Player_B_y] > 0 && harita[Player_B_x][Player_B_y] < 21) {//gorunur altin var mi
                                        Player_B_Altin = harita[Player_B_x][Player_B_y] + Player_B_Altin;
                                        toplanan_toplam_altin_B = toplanan_toplam_altin_B + harita[Player_B_x][Player_B_y];
                                        System.out.println("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("\n");
                                        harita[Player_B_x][Player_B_y] = 22;
                                        bir_adimda_atlanacak_kare_B = 0;
                                        B_Hedef_belirledi = false;
                                        System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                         bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                         bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_B_x && j == Player_B_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 22) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_B_x][Player_B_y] < 0) {
                                        harita[Player_B_x][Player_B_y] = harita[Player_B_x][Player_B_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_B_x][Player_B_y] == 0) {
                                        harita[Player_B_x][Player_B_y] = 22;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_B_x && j == Player_B_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 22) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_B_adim_y > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_B--;
                                    Player_B_y--;
                                    atilan_adim_sayisi_B++;
                                    if (harita[Player_B_x][Player_B_y] > 0 && harita[Player_B_x][Player_B_y] < 21) {//gorunur altin var mi
                                        Player_B_Altin = harita[Player_B_x][Player_B_y] + Player_B_Altin;
                                        toplanan_toplam_altin_B = toplanan_toplam_altin_B + harita[Player_B_x][Player_B_y];
                                        System.out.println("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("player B nin altini arttirildi+" + harita[Player_B_x][Player_B_y] + " yeni altin=" + Player_B_Altin);
                                        bWriter.write("\n");
                                        harita[Player_B_x][Player_B_y] = 22;
                                        bir_adimda_atlanacak_kare_B = 0;
                                        B_Hedef_belirledi = false;
                                        System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_B_x && j == Player_B_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 22) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_B_x][Player_B_y] < 0) {
                                        harita[Player_B_x][Player_B_y] = harita[Player_B_x][Player_B_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_B_x][Player_B_y] == 0) {
                                        harita[Player_B_x][Player_B_y] = 22;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_B_x && j == Player_B_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 22) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("player B 'nin x=" + Player_B_x + " y= " + Player_B_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                }

                            }

                        }
                        if (bir_adimda_atlanacak_kare_B == 0) {
                            Player_B_Altin = Player_B_Altin - Player_B_Hamle_maaliyet;
                            harcanan_toplam_altin_B = harcanan_toplam_altin_B + Player_B_Hamle_maaliyet;
                            System.out.println("Player B hamle maaliyeti=" + Player_B_Hamle_maaliyet + " Altin=" + Player_B_Altin);
                            bWriter.write("Player B hamle maaliyeti=" + Player_B_Hamle_maaliyet + " Altin=" + Player_B_Altin);
                            bWriter.write("\n");
                            System.out.println("turun bitti bir sonraki tura geç");
                            bWriter.write("turun bitti bir sonraki tura geç");
                            bWriter.write("\n");
                            if (Player_B_Altin < Player_B_Hamle_maaliyet) {
                                System.out.println("Player B elendi .Altın=" + Player_B_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("Player B elendi .Altın=" + Player_B_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("\n");
                                B_elendi_mi = 1;
                                System.out.println("assss");
                                bir_adimda_atlanacak_kare_B = 0;

                            } else {
                                bir_adimda_atlanacak_kare_B = bir_hamlede_kac_kare;
                            }
                            A_sira = 0;
                            B_sira = 0;
                            C_sira = 1;
                            D_sira = 0;
                            while (buttona_Bas) {

                            }
                            buttona_Bas = true;
                            TimeUnit.SECONDS.sleep(1);
                        }

                    }
                }
            }
            A_sira = 0;
            B_sira = 0;
            C_sira = 1;
            D_sira = 0;
            //CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC
            //CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC
            //CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC
            //CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC
            //CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC//CCCCCCCCCCCCCCCCCCCC

            if (C_sira == 1 && oyun_devam(harita)) {

                if (C_elendi_mi == 0) {
                    if (Player_C_Altin < Player_C_Hedef_maaliyet) {
                        System.out.println("hedef maaliyet=" + Player_C_Hedef_maaliyet + " C elendi hedef icin yetersiz altin sa altin=" + Player_C_Altin);
                         bWriter.write("hedef maaliyet=" + Player_C_Hedef_maaliyet + " C elendi hedef icin yetersiz altin sa altin=" + Player_C_Altin);
                         bWriter.write("\n");
                        C_elendi_mi = 1;
                        A_sira = 0;
                        B_sira = 0;
                        C_sira = 0;
                        D_sira = 1;
                    }

                    if (oyun_devam(harita) && !C_Hedef_belirledi(harita, en_yakin_koordinat_C.x, en_yakin_koordinat_C.y) && Player_C_Altin >= Player_C_Hedef_maaliyet && C_elendi_mi == 0) {

//gizli altinlarin mesafesi ve koordinatlarini bulma  C YE ozel
                        ///////////////////////////////////// /////////////////////////////////////    c  ozel ///////////////////////////////////// 
                        ///////////////////////////////////// /////////////////////////////////////    c ozel  /////////////////////////////////////   
                        ///////////////////////////////////// /////////////////////////////////////      c ozel /////////////////////////////////////   
                        ///////////////////////////////////// /////////////////////////////////////    c  ozel /////////////////////////////////////   
                        for (int i = 0; i < harita.length; i++) {
                            for (int j = 0; j < harita[0].length; j++) {
                                if (harita[i][j] < 0) {
                                    toplam_C_ozel = toplam_C_ozel + (Math.abs(Player_C_x - i)) + (Math.abs(Player_C_y - j));
                                    mesafeler_C_ozel.add(toplam_C_ozel);
                                    Koordinat koordinat_C_ozel = new Koordinat(i, j, toplam_C_ozel);
                                    koordinatlar_C_ozel.add(koordinat_C_ozel);
                                    toplam_C_ozel = 0;

                                }

                            }

                        }

                        //gizli altinlari siralama
                        /*for (int i = 0; i < koordinatlar_C_ozel.size(); i++) {

                            System.out.println("x=" + koordinatlar_C_ozel.get(i).x + "y=" + koordinatlar_C_ozel.get(i).y + "mesafesi=" + koordinatlar_C_ozel.get(i).mesafe);
                        }*/
                        Collections.sort(koordinatlar_C_ozel, new Comparator<Koordinat>() {
                            public int compare(Koordinat k1, Koordinat k2) {
                                return Integer.valueOf(k1.mesafe).compareTo(k2.mesafe);
                            }
                        });
                        /*System.out.println("siralanmis haliii---------------");
                        for (int i = 0; i < koordinatlar_C_ozel.size(); i++) {

                            System.out.println("x=" + koordinatlar_C_ozel.get(i).x + "y=" + koordinatlar_C_ozel.get(i).y + "mesafesi=" + koordinatlar_C_ozel.get(i).mesafe);
                        }*/

                        for (int i = 0; i < koordinatlar_C_ozel.size(); i++) {
                            System.out.println("--C'nin ozel yetenegi gizli altin aciga cikarildi--\n" + "x=" + koordinatlar_C_ozel.get(i).x + "y=" + koordinatlar_C_ozel.get(i).y + "mesafesi=" + koordinatlar_C_ozel.get(i).mesafe);
                             bWriter.write("--C'nin ozel yetenegi gizli altin aciga cikarildi--\n" + "x=" + koordinatlar_C_ozel.get(i).x + "y=" + koordinatlar_C_ozel.get(i).y + "mesafesi=" + koordinatlar_C_ozel.get(i).mesafe);
                             bWriter.write("\n");
                            harita[koordinatlar_C_ozel.get(i).x][koordinatlar_C_ozel.get(i).y] = -1 * harita[koordinatlar_C_ozel.get(i).x][koordinatlar_C_ozel.get(i).y];
                            C_kac_tane_gizli_altini_gorsun--;
                            if (C_kac_tane_gizli_altini_gorsun == 0) {
                                break;
                            }
                        }

                        C_kac_tane_gizli_altini_gorsun = c_gorulen_gizli_altin;
                        mesafeler_C_ozel.clear();
                        koordinatlar_C_ozel.clear();
                        ///////////////////////////////////// /////////////////////////////////////    c  ozel ///////////////////////////////////// 
                        ///////////////////////////////////// /////////////////////////////////////    c ozel  /////////////////////////////////////   
                        ///////////////////////////////////// /////////////////////////////////////      c ozel /////////////////////////////////////   
                        ///////////////////////////////////// /////////////////////////////////////    c  ozel /////////////////////////////////////   
//Player c'ya gore altınların mesafesi ve koordinatlarını bulma
                        mesafeler_C_ozel.clear();
                        koordinatlar_C_ozel.clear();
                        for (int i = 0; i < harita.length; i++) {
                            for (int j = 0; j < harita[0].length; j++) {
                                if (harita[i][j] > 0 && harita[i][j] < 21) {
                                    toplam_C = toplam_C + (Math.abs(Player_C_x - i)) + (Math.abs(Player_C_y - j));
                                    mesafeler_C.add(toplam_C);
                                    Koordinat koordinat_C = new Koordinat(i, j, toplam_C);
                                    koordinatlar_C.add(koordinat_C);
                                    toplam_C = 0;

                                }

                            }

                        }
                        //Player B'ya gore altinlarin mesafeleri ve koordinatları yazdirma

                        /* for (int i = 0; i < koordinatlar_B.size(); i++) {
                    
                            System.out.println("x=" + koordinatlar_B.get(i).x + "y=" + koordinatlar_B.get(i).y + "mesafesi=" + koordinatlar_B.get(i).mesafe);
                }*/
                        //en yakın Altını secme algoritması
                        en_yakin_koordinat_C.setX(koordinatlar_C.get(0).x);
                        en_yakin_koordinat_C.setY(koordinatlar_C.get(0).y);
                        en_yakin_koordinat_C.setMesafe(koordinatlar_C.get(0).mesafe);
                        int kac_hamle_C = (int) Math.ceil((double) koordinatlar_C.get(0).mesafe / bir_adimda_atlanacak_kare_C);
                        int en_karli_C = harita[koordinatlar_C.get(0).x][koordinatlar_C.get(0).y] - (kac_hamle_C * Player_C_Hamle_maaliyet);
                        int temp = en_karli_C;
                        for (int i = 0; i < koordinatlar_C.size(); i++) {
                            kac_hamle_C = (int) Math.ceil((double) koordinatlar_C.get(i).mesafe / bir_adimda_atlanacak_kare_C);
                            en_karli_C = harita[koordinatlar_C.get(i).x][koordinatlar_C.get(i).y] - (kac_hamle_C * Player_C_Hamle_maaliyet);
                            if (temp < en_karli_C) {
                                temp = en_karli_C;
                                en_yakin_koordinat_C.mesafe = koordinatlar_C.get(i).mesafe;
                                en_yakin_koordinat_C.x = koordinatlar_C.get(i).x;
                                en_yakin_koordinat_C.y = koordinatlar_C.get(i).y;

                            }

                        }

                        //TimeUnit.SECONDS.sleep(2);
                        System.out.println("Hedef Belirlendi...");
                        bWriter.write("Hedef Belirlendi...");
                        bWriter.write("\n");
                        System.out.println("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_C.x + " y=" + en_yakin_koordinat_C.y + " mesafesi=" + en_yakin_koordinat_C.mesafe + " degeri= " + harita[en_yakin_koordinat_C.x][en_yakin_koordinat_C.y] + " kaari=" + temp);
                        bWriter.write("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_C.x + " y=" + en_yakin_koordinat_C.y + " mesafesi=" + en_yakin_koordinat_C.mesafe + " degeri= " + harita[en_yakin_koordinat_C.x][en_yakin_koordinat_C.y] + " kaari=" + temp);
                        bWriter.write("\n");
                        mesafeler_C.clear();
                        koordinatlar_C.clear();
                        C_Hedef_belirledi = true;
                        Player_C_Altin = Player_C_Altin - Player_C_Hedef_maaliyet;
                        harcanan_toplam_altin_C = harcanan_toplam_altin_C + Player_C_Hedef_maaliyet;
                        System.out.println("Player C Hedef belirledi maaliyeti=" + Player_C_Hedef_maaliyet + "  Altin =" + Player_C_Altin);
                        bWriter.write("Player C Hedef belirledi maaliyeti=" + Player_C_Hedef_maaliyet + "  Altin =" + Player_C_Altin);
                        bWriter.write("\n");

                    }
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    //HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC//HAREKET ETME CCCCCCC
                    if (oyun_devam(harita) && C_Hedef_belirledi(harita, en_yakin_koordinat_C.x, en_yakin_koordinat_C.y) && Player_C_Altin >= Player_C_Hamle_maaliyet && C_elendi_mi == 0) {

                        int Player_C_adim_x = Player_C_x - en_yakin_koordinat_C.x;
                        int Player_C_adim_y = Player_C_y - en_yakin_koordinat_C.y;
                        for (int i = 0; i < Math.abs(Player_C_adim_x); i++) {
                            if (bir_adimda_atlanacak_kare_C > 0) {
                                if (Player_C_adim_x < 0) {
                                    bir_adimda_atlanacak_kare_C--;
                                    Player_C_x++;
                                    atilan_adim_sayisi_C++;
                                    if (harita[Player_C_x][Player_C_y] > 0 && harita[Player_C_x][Player_C_y] < 21) {//gorunur altin var mi
                                        Player_C_Altin = harita[Player_C_x][Player_C_y] + Player_C_Altin;
                                        toplanan_toplam_altin_C = toplanan_toplam_altin_C + harita[Player_C_x][Player_C_y];
                                        System.out.println("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("\n");
                                        harita[Player_C_x][Player_C_y] = 23;
                                        bir_adimda_atlanacak_kare_C = 0;
                                        C_Hedef_belirledi = false;
                                        System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_C_x && j == Player_C_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 23) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_C_x][Player_C_y] < 0) {
                                        harita[Player_C_x][Player_C_y] = harita[Player_C_x][Player_C_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_C_x][Player_C_y] == 0) {
                                        harita[Player_C_x][Player_C_y] = 23;

                                    }

                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_C_x && j == Player_C_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 23) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_C_adim_x > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_C--;
                                    Player_C_x--;
                                    atilan_adim_sayisi_C++;
                                    if (harita[Player_C_x][Player_C_y] > 0 && harita[Player_C_x][Player_C_y] < 21) {//gorunur altin var mi
                                        Player_C_Altin = harita[Player_C_x][Player_C_y] + Player_C_Altin;
                                        toplanan_toplam_altin_C = toplanan_toplam_altin_C + harita[Player_C_x][Player_C_y];
                                        System.out.println("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("\n");
                                        harita[Player_C_x][Player_C_y] = 23;
                                        bir_adimda_atlanacak_kare_C = 0;
                                        C_Hedef_belirledi = false;
                                        System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_C_x && j == Player_C_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 23) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_C_x][Player_C_y] < 0) {
                                        harita[Player_C_x][Player_C_y] = harita[Player_C_x][Player_C_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_C_x][Player_C_y] == 0) {
                                        harita[Player_C_x][Player_C_y] = 23;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_C_x && j == Player_C_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 23) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);
                                }

                            }

                        }
                        for (int i = 0; i < Math.abs(Player_C_adim_y); i++) {

                            if (bir_adimda_atlanacak_kare_C > 0) {

                                if (Player_C_adim_y < 0) {
                                    //TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_C--;
                                    Player_C_y++;
                                    atilan_adim_sayisi_C++;
                                    if (harita[Player_C_x][Player_C_y] > 0 && harita[Player_C_x][Player_C_y] < 21) {//gorunur altin var mi
                                        Player_C_Altin = harita[Player_C_x][Player_C_y] + Player_C_Altin;
                                        toplanan_toplam_altin_C = toplanan_toplam_altin_C + harita[Player_C_x][Player_C_y];
                                        System.out.println("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("\n");
                                        harita[Player_C_x][Player_C_y] = 23;
                                        bir_adimda_atlanacak_kare_C = 0;
                                        C_Hedef_belirledi = false;
                                        System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_C_x && j == Player_C_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 23) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_C_x][Player_C_y] < 0) {
                                        harita[Player_C_x][Player_C_y] = harita[Player_C_x][Player_C_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_C_x][Player_C_y] == 0) {
                                        harita[Player_C_x][Player_C_y] = 23;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_C_x && j == Player_C_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 23) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_C_adim_y > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_C--;
                                    Player_C_y--;
                                    atilan_adim_sayisi_C++;
                                    if (harita[Player_C_x][Player_C_y] > 0 && harita[Player_C_x][Player_C_y] < 21) {//gorunur altin var mi
                                        Player_C_Altin = harita[Player_C_x][Player_C_y] + Player_C_Altin;
                                        toplanan_toplam_altin_C = toplanan_toplam_altin_C + harita[Player_C_x][Player_C_y];
                                        System.out.println("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("player C nin altini arttirildi+" + harita[Player_C_x][Player_C_y] + " yeni altin=" + Player_C_Altin);
                                        bWriter.write("\n");
                                        harita[Player_C_x][Player_C_y] = 23;
                                        bir_adimda_atlanacak_kare_C = 0;
                                        C_Hedef_belirledi = false;
                                        System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_C_x && j == Player_C_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 23) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_C_x][Player_C_y] < 0) {
                                        harita[Player_C_x][Player_C_y] = harita[Player_C_x][Player_C_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_C_x][Player_C_y] == 0) {
                                        harita[Player_C_x][Player_C_y] = 23;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_C_x && j == Player_C_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 23) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("player C 'nin x=" + Player_C_x + " y= " + Player_C_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                }

                            }

                        }
                        if (bir_adimda_atlanacak_kare_C == 0) {
                            Player_C_Altin = Player_C_Altin - Player_C_Hamle_maaliyet;
                            harcanan_toplam_altin_C = harcanan_toplam_altin_C + Player_C_Hamle_maaliyet;
                            System.out.println("Player C hamle maaliyeti=" + Player_C_Hamle_maaliyet + " Altin=" + Player_C_Altin);
                            bWriter.write("Player C hamle maaliyeti=" + Player_C_Hamle_maaliyet + " Altin=" + Player_C_Altin);
                            bWriter.write("\n");
                            System.out.println("turun bitti bir sonraki tura geç");
                            bWriter.write("turun bitti bir sonraki tura geç");
                            bWriter.write("\n");
                            if (Player_C_Altin < Player_C_Hamle_maaliyet) {
                                System.out.println("Player C elendi .Altın=" + Player_C_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("Player C elendi .Altın=" + Player_C_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("\n");
                                C_elendi_mi = 1;
                                System.out.println("assss");
                                bir_adimda_atlanacak_kare_C = 0;

                            } else {
                                bir_adimda_atlanacak_kare_C = bir_hamlede_kac_kare;
                            }
                            A_sira = 0;
                            B_sira = 0;
                            C_sira = 0;
                            D_sira = 1;
                            while (buttona_Bas) {

                            }
                            buttona_Bas = true;
                            TimeUnit.SECONDS.sleep(1);

                        }

                    }
                }
            }
            A_sira = 0;
            B_sira = 0;
            C_sira = 0;
            D_sira = 1;
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            ////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD////DDDDDDDDDDDDDDDDDDDDDDD
            if (D_sira == 1 && oyun_devam(harita)) {
                if (D_elendi_mi == 0) {

                    if (Player_D_Altin < Player_D_Hedef_maaliyet) {
                        System.out.println("hedef maaliyet=" + Player_D_Hedef_maaliyet + " D elendi hedef icin yetersiz altin sa altin=" + Player_D_Altin);
                        bWriter.write("hedef maaliyet=" + Player_D_Hedef_maaliyet + " D elendi hedef icin yetersiz altin sa altin=" + Player_D_Altin);
                        bWriter.write("\n");
                        D_elendi_mi = 1;
                        A_sira = 1;
                        B_sira = 0;
                        C_sira = 0;
                        D_sira = 0;
                    }

                    if (oyun_devam(harita) && !D_Hedef_belirledi(harita, en_yakin_koordinat_D.x, en_yakin_koordinat_D.y) && Player_D_Altin >= Player_D_Hedef_maaliyet && D_elendi_mi == 0) {

//Player D'ya gore altınların mesafesi ve koordinatlarını bulma
                        for (int i = 0; i < harita.length; i++) {
                            for (int j = 0; j < harita[0].length; j++) {
                                if (harita[i][j] > 0 && harita[i][j] < 21) {
                                    toplam_D = toplam_D + (Math.abs(Player_D_x - i)) + (Math.abs(Player_D_y - j));
                                    mesafeler_D.add(toplam_D);
                                    Koordinat koordinat_D = new Koordinat(i, j, toplam_D);
                                    koordinatlar_D.add(koordinat_D);
                                    toplam_D = 0;

                                }

                            }

                        }

                        //D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
                        //D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
                        //D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
                        //D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
                        //D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
                        for (int i = 0; i < koordinatlar_D.size(); i++) {

                            System.out.println("x=" + koordinatlar_D.get(i).x + "y=" + koordinatlar_D.get(i).y + "mesafesi=" + koordinatlar_D.get(i).mesafe);
                        }

                        System.out.println("----PLAYER D diger oyuncuların hedefledikleri altinlari gosteriyor-----");
                        bWriter.write("----PLAYER D diger oyuncuların hedefledikleri altinlari gosteriyor-----");
                        bWriter.write("\n");

                        if (harita[en_yakin_koordinat_A.x][en_yakin_koordinat_A.y] > 0 && harita[en_yakin_koordinat_A.x][en_yakin_koordinat_A.y] < 21) {
                            int A_ya_mesafesi = (Math.abs(Player_A_x - en_yakin_koordinat_A.x)) + (Math.abs(Player_A_y - en_yakin_koordinat_A.y));
                            int A_kac_hamlede = (int) Math.ceil((double) A_ya_mesafesi / bir_adimda_atlanacak_kare_A);

                            System.out.println("A'nin hedefi x=" + en_yakin_koordinat_A.x + " y=" + en_yakin_koordinat_A.y + " A'ya uzakligi= " + A_ya_mesafesi + " Player A kac hamlede gider=" + A_kac_hamlede);
                            bWriter.write("A'nin hedefi x=" + en_yakin_koordinat_A.x + " y=" + en_yakin_koordinat_A.y + " A'ya uzakligi= " + A_ya_mesafesi + " Player A kac hamlede gider=" + A_kac_hamlede);
                            bWriter.write("\n");
                            int D_ya_mesafesi = (Math.abs(Player_D_x - en_yakin_koordinat_A.x)) + (Math.abs(Player_D_y - en_yakin_koordinat_A.y));
                            int D_kac_hamlede = (int) Math.ceil((double) D_ya_mesafesi / bir_adimda_atlanacak_kare_D);
                            System.out.println("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("\n");
                            if (D_kac_hamlede > A_kac_hamlede) {
                                System.out.println("Bu altin haric tutuldu ");
                                bWriter.write("Bu altin haric tutuldu ");
                                bWriter.write("\n");
                                int atilacak = -1;
                                for (int i = 0; i < koordinatlar_D.size(); i++) {
                                    if (koordinatlar_D.get(i).x == en_yakin_koordinat_A.x && koordinatlar_D.get(i).y == en_yakin_koordinat_A.y) {
                                        atilacak = i;
                                    }

                                }
                                if (atilacak >= 0) {
                                    koordinatlar_D.remove(atilacak);
                                }

                            }
                        }
                        if (harita[en_yakin_koordinat_B.x][en_yakin_koordinat_B.y] > 0 && harita[en_yakin_koordinat_B.x][en_yakin_koordinat_B.y] < 21) {
                            int B_ya_mesafesi = (Math.abs(Player_B_x - en_yakin_koordinat_B.x)) + (Math.abs(Player_B_y - en_yakin_koordinat_B.y));
                            int B_kac_hamlede = (int) Math.ceil((double) B_ya_mesafesi / bir_adimda_atlanacak_kare_B);
                            System.out.println("B'nin hedefi x=" + en_yakin_koordinat_B.x + " y=" + en_yakin_koordinat_B.y + " B'ya uzakligi= " + B_ya_mesafesi + " Player B kac hamlede gider=" + B_kac_hamlede);
                            bWriter.write("B'nin hedefi x=" + en_yakin_koordinat_B.x + " y=" + en_yakin_koordinat_B.y + " B'ya uzakligi= " + B_ya_mesafesi + " Player B kac hamlede gider=" + B_kac_hamlede);
                            bWriter.write("\n");
                            int D_ya_mesafesi = (Math.abs(Player_D_x - en_yakin_koordinat_B.x)) + (Math.abs(Player_D_y - en_yakin_koordinat_B.y));
                            int D_kac_hamlede = (int) Math.ceil((double) D_ya_mesafesi / bir_adimda_atlanacak_kare_D);
                            System.out.println("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("\n");
                            if (D_kac_hamlede > B_kac_hamlede) {
                                System.out.println("Bu altin haric tutuldu ");
                                bWriter.write("Bu altin haric tutuldu ");
                                bWriter.write("\n");
                                int atilacak = -1;
                                for (int i = 0; i < koordinatlar_D.size(); i++) {
                                    if (koordinatlar_D.get(i).x == en_yakin_koordinat_B.x && koordinatlar_D.get(i).y == en_yakin_koordinat_B.y) {
                                        atilacak = i;
                                    }

                                }
                                if (atilacak >= 0) {
                                    koordinatlar_D.remove(atilacak);
                                }
                            }
                        }
                        if (harita[en_yakin_koordinat_C.x][en_yakin_koordinat_C.y] > 0 && harita[en_yakin_koordinat_C.x][en_yakin_koordinat_C.y] < 21) {
                            int C_ya_mesafesi = (Math.abs(Player_C_x - en_yakin_koordinat_C.x)) + (Math.abs(Player_C_y - en_yakin_koordinat_C.y));
                            int C_kac_hamlede = (int) Math.ceil((double) C_ya_mesafesi / bir_adimda_atlanacak_kare_C);
                            System.out.println("C'nin hedefi x=" + en_yakin_koordinat_C.x + " y=" + en_yakin_koordinat_C.y + " C'ya uzakligi= " + C_ya_mesafesi + " Player C kac hamlede gider=" + C_kac_hamlede);
                            bWriter.write("C'nin hedefi x=" + en_yakin_koordinat_C.x + " y=" + en_yakin_koordinat_C.y + " C'ya uzakligi= " + C_ya_mesafesi + " Player C kac hamlede gider=" + C_kac_hamlede);
                            bWriter.write("\n");
                            int D_ya_mesafesi = (Math.abs(Player_D_x - en_yakin_koordinat_C.x)) + (Math.abs(Player_D_y - en_yakin_koordinat_C.y));
                            int D_kac_hamlede = (int) Math.ceil((double) D_ya_mesafesi / bir_adimda_atlanacak_kare_D);
                            System.out.println("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("bu altinin D'YE MESAFESİ=" + D_ya_mesafesi + " kac hamlede=" + D_kac_hamlede);
                            bWriter.write("\n");
                            if (D_kac_hamlede > C_kac_hamlede) {
                                System.out.println("Bu altin haric tutuldu ");
                                bWriter.write("Bu altin haric tutuldu ");
                                bWriter.write("\n");
                                int atilacak = -1;
                                for (int i = 0; i < koordinatlar_D.size(); i++) {
                                    if (koordinatlar_D.get(i).x == en_yakin_koordinat_C.x && koordinatlar_D.get(i).y == en_yakin_koordinat_C.y) {
                                        atilacak = i;
                                    }

                                }
                                if (atilacak >= 0) {
                                    koordinatlar_D.remove(atilacak);
                                }
                            }
                        }

//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL//D'YE OZEL
//Player D'ya gore altinlarin mesafeleri ve koordinatları yazdirma
                        for (int i = 0; i < koordinatlar_D.size(); i++) {

                            System.out.println("x=" + koordinatlar_D.get(i).x + "y=" + koordinatlar_D.get(i).y + "mesafesi=" + koordinatlar_D.get(i).mesafe);
                        }
                        //en yakın Altını secme algoritması
                        if (koordinatlar_D.size() > 0) {
                            en_yakin_koordinat_D.setX(koordinatlar_D.get(0).x);
                            en_yakin_koordinat_D.setY(koordinatlar_D.get(0).y);
                            en_yakin_koordinat_D.setMesafe(koordinatlar_D.get(0).mesafe);
                            int kac_hamle_D = (int) Math.ceil((double) koordinatlar_D.get(0).mesafe / bir_adimda_atlanacak_kare_D);
                            int en_karli_D = harita[koordinatlar_D.get(0).x][koordinatlar_D.get(0).y] - (kac_hamle_D * Player_D_Hamle_maaliyet);
                            int temp = en_karli_D;
                            for (int i = 0; i < koordinatlar_D.size(); i++) {
                                kac_hamle_D = (int) Math.ceil((double) koordinatlar_D.get(i).mesafe / bir_adimda_atlanacak_kare_D);
                                en_karli_D = harita[koordinatlar_D.get(i).x][koordinatlar_D.get(i).y] - (kac_hamle_D * Player_D_Hamle_maaliyet);
                                if (temp < en_karli_D) {
                                    temp = en_karli_D;
                                    en_yakin_koordinat_D.mesafe = koordinatlar_D.get(i).mesafe;
                                    en_yakin_koordinat_D.x = koordinatlar_D.get(i).x;
                                    en_yakin_koordinat_D.y = koordinatlar_D.get(i).y;

                                }

                            }
                            System.out.println("Hedef Belirlendi...");
                            bWriter.write("Hedef Belirlendi...");
                            bWriter.write("\n");
                            System.out.println("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_D.x + " y=" + en_yakin_koordinat_D.y + " mesafesi=" + en_yakin_koordinat_D.mesafe + " degeri= " + harita[en_yakin_koordinat_D.x][en_yakin_koordinat_D.y] + " kaari=" + temp);
                            bWriter.write("en karli nokta bilgisi\n" + " x=" + en_yakin_koordinat_D.x + " y=" + en_yakin_koordinat_D.y + " mesafesi=" + en_yakin_koordinat_D.mesafe + " degeri= " + harita[en_yakin_koordinat_D.x][en_yakin_koordinat_D.y] + " kaari=" + temp);
                            bWriter.write("\n");
                            mesafeler_D.clear();
                            koordinatlar_D.clear();
                            D_Hedef_belirledi = true;
                            Player_D_Altin = Player_D_Altin - Player_D_Hedef_maaliyet;
                            harcanan_toplam_altin_D = harcanan_toplam_altin_D + Player_D_Hedef_maaliyet;
                            System.out.println("Player D Hedef belirledi maaliyeti=" + Player_D_Hedef_maaliyet + "  Altin =" + Player_D_Altin);
                            bWriter.write("Player D Hedef belirledi maaliyeti=" + Player_D_Hedef_maaliyet + "  Altin =" + Player_D_Altin);
                            bWriter.write("\n");
                        }

                        //TimeUnit.SECONDS.sleep(2);
                    }

                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    //HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD//HAREKET ETME DDD
                    if (oyun_devam(harita) && D_elendi_mi == 0 && D_Hedef_belirledi(harita, en_yakin_koordinat_D.x, en_yakin_koordinat_D.y) && Player_D_Altin >= Player_D_Hamle_maaliyet) {

                        int Player_D_adim_x = Player_D_x - en_yakin_koordinat_D.x;
                        int Player_D_adim_y = Player_D_y - en_yakin_koordinat_D.y;
                        for (int i = 0; i < Math.abs(Player_D_adim_x); i++) {
                            if (bir_adimda_atlanacak_kare_D > 0) {
                                if (Player_D_adim_x < 0) {
                                    bir_adimda_atlanacak_kare_D--;
                                    Player_D_x++;
                                    atilan_adim_sayisi_D++;
                                    if (harita[Player_D_x][Player_D_y] > 0 && harita[Player_D_x][Player_D_y] < 21) {//gorunur altin var mi
                                        Player_D_Altin = harita[Player_D_x][Player_D_y] + Player_D_Altin;
                                        toplanan_toplam_altin_D = toplanan_toplam_altin_D + harita[Player_D_x][Player_D_y];
                                        System.out.println("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("\n");
                                        harita[Player_D_x][Player_D_y] = 24;
                                        bir_adimda_atlanacak_kare_D = 0;
                                        D_Hedef_belirledi = false;
                                        System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_D_x && j == Player_D_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 24) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_D_x][Player_D_y] < 0) {
                                        harita[Player_D_x][Player_D_y] = harita[Player_D_x][Player_D_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_D_x][Player_D_y] == 0) {
                                        harita[Player_D_x][Player_D_y] = 24;

                                    }

                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_D_x && j == Player_D_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 24) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_D_adim_x > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_D--;
                                    Player_D_x--;
                                    atilan_adim_sayisi_D++;
                                    if (harita[Player_D_x][Player_D_y] > 0 && harita[Player_D_x][Player_D_y] < 21) {//gorunur altin var mi
                                        Player_D_Altin = harita[Player_D_x][Player_D_y] + Player_D_Altin;
                                        toplanan_toplam_altin_D = toplanan_toplam_altin_D + harita[Player_D_x][Player_D_y];
                                        System.out.println("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("\n");
                                        harita[Player_D_x][Player_D_y] = 24;
                                        bir_adimda_atlanacak_kare_D = 0;
                                        D_Hedef_belirledi = false;
                                        System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_D_x && j == Player_D_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 24) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_D_x][Player_D_y] < 0) {
                                        harita[Player_D_x][Player_D_y] = harita[Player_D_x][Player_D_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_D_x][Player_D_y] == 0) {
                                        harita[Player_D_x][Player_D_y] = 24;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_D_x && j == Player_D_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 24) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);
                                }

                            }

                        }
                        for (int i = 0; i < Math.abs(Player_D_adim_y); i++) {

                            if (bir_adimda_atlanacak_kare_D > 0) {

                                if (Player_D_adim_y < 0) {
                                    //TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_D--;
                                    Player_D_y++;
                                    atilan_adim_sayisi_D++;
                                    if (harita[Player_D_x][Player_D_y] > 0 && harita[Player_D_x][Player_D_y] < 21) {//gorunur altin var mi
                                        Player_D_Altin = harita[Player_D_x][Player_D_y] + Player_D_Altin;
                                        toplanan_toplam_altin_D = toplanan_toplam_altin_D + harita[Player_D_x][Player_D_y];
                                        System.out.println("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("\n");
                                        harita[Player_D_x][Player_D_y] = 24;
                                        bir_adimda_atlanacak_kare_D = 0;
                                        D_Hedef_belirledi = false;
                                        System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_D_x && j == Player_D_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 24) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_D_x][Player_D_y] < 0) {
                                        harita[Player_D_x][Player_D_y] = harita[Player_D_x][Player_D_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_D_x][Player_D_y] == 0) {
                                        harita[Player_D_x][Player_D_y] = 24;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_D_x && j == Player_D_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 24) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                } else if (Player_D_adim_y > 0) {
                                    // TimeUnit.SECONDS.sleep(2);
                                    bir_adimda_atlanacak_kare_D--;
                                    Player_D_y--;
                                    atilan_adim_sayisi_D++;
                                    if (harita[Player_D_x][Player_D_y] > 0 && harita[Player_D_x][Player_D_y] < 21) {//gorunur altin var mi
                                        Player_D_Altin = harita[Player_D_x][Player_D_y] + Player_D_Altin;
                                        toplanan_toplam_altin_D = toplanan_toplam_altin_D + harita[Player_D_x][Player_D_y];
                                        System.out.println("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("player D nin altini arttirildi+" + harita[Player_D_x][Player_D_y] + " yeni altin=" + Player_D_Altin);
                                        bWriter.write("\n");
                                        harita[Player_D_x][Player_D_y] = 24;
                                        bir_adimda_atlanacak_kare_D = 0;
                                        D_Hedef_belirledi = false;
                                        System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                        bWriter.write("\n");
                                        for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                            for (int j = 0; j < harita[0].length; j++) {
                                                if (k == Player_D_x && j == Player_D_y) {
                                                    continue;
                                                }
                                                if (harita[k][j] == 24) {
                                                    harita[k][j] = 0;
                                                }
                                            }

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        Yazdir(harita);
                                        grafik.harita = harita;
                                        grafik.repaint();
                                        TimeUnit.SECONDS.sleep(1);
                                        break;
                                    }
                                    if (harita[Player_D_x][Player_D_y] < 0) {
                                        harita[Player_D_x][Player_D_y] = harita[Player_D_x][Player_D_y] * -1;
                                        System.out.println("gizli altin bulundu");
                                        bWriter.write("gizli altin bulundu");
                                        bWriter.write("\n");
                                    }
                                    if (harita[Player_D_x][Player_D_y] == 0) {
                                        harita[Player_D_x][Player_D_y] = 24;

                                    }
                                    for (int k = 0; k < harita.length; k++) {//***///**BU KİSİM DAHA SONRA OYUNCULARA GORE DEGİSTİRİLCEK
                                        for (int j = 0; j < harita[0].length; j++) {
                                            if (k == Player_D_x && j == Player_D_y) {
                                                continue;
                                            }
                                            if (harita[k][j] == 24) {
                                                harita[k][j] = 0;
                                            }
                                        }

                                    }

                                    System.out.println("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("player D 'nin x=" + Player_D_x + " y= " + Player_D_y);
                                    bWriter.write("\n");
                                    TimeUnit.SECONDS.sleep(1);
                                    Yazdir(harita);
                                    grafik.harita = harita;
                                    grafik.repaint();
                                    TimeUnit.SECONDS.sleep(1);

                                }

                            }

                        }
                        if (bir_adimda_atlanacak_kare_D == 0) {
                            Player_D_Altin = Player_D_Altin - Player_D_Hamle_maaliyet;
                            harcanan_toplam_altin_D = harcanan_toplam_altin_D + Player_D_Hamle_maaliyet;
                            System.out.println("Player D hamle maaliyeti=" + Player_D_Hamle_maaliyet + " Altin=" + Player_D_Altin);
                            bWriter.write("Player D hamle maaliyeti=" + Player_D_Hamle_maaliyet + " Altin=" + Player_D_Altin);
                            bWriter.write("\n");
                            System.out.println("turun bitti bir sonraki tura geç");
                            bWriter.write("turun bitti bir sonraki tura geç");
                            bWriter.write("\n");
                            if (Player_D_Altin < Player_D_Hamle_maaliyet) {
                                System.out.println("Player D elendi .Altın=" + Player_D_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("Player D elendi .Altın=" + Player_D_Altin + " Bir sonraki hamle veya hedef icin yetersiz Altin.");
                                bWriter.write("\n");
                                D_elendi_mi = 1;
                                System.out.println("assss");
                                bir_adimda_atlanacak_kare_D = 0;

                            } else {
                                bir_adimda_atlanacak_kare_D = bir_hamlede_kac_kare;
                            }
                            A_sira = 1;
                            B_sira = 0;
                            C_sira = 0;
                            D_sira = 0;
                            while (buttona_Bas) {

                            }
                            buttona_Bas = true;
                            TimeUnit.SECONDS.sleep(1);
                        }

                    }
                }

            }
            A_sira = 1;
            B_sira = 0;
            C_sira = 0;
            D_sira = 0;

        }
        System.out.println("A'nin toplam adim sayisi="+atilan_adim_sayisi_A);
        System.out.println("A'nin kasadaki altin miktari="+Player_A_Altin);
        System.out.println("A'nin harcadigi altin sayisi="+harcanan_toplam_altin_A);
        System.out.println("A'nin kazandigi altin sayisi="+toplanan_toplam_altin_A);
        System.out.println("---------------------------------------------------------");
        System.out.println("B'nin toplam adim sayisi="+atilan_adim_sayisi_B);
        System.out.println("B'nin kasadaki altin miktari="+Player_B_Altin);
        System.out.println("B'nin harcadigi altin sayisi="+harcanan_toplam_altin_B);
        System.out.println("B'nin kazandigi altin sayisi="+toplanan_toplam_altin_B);
        System.out.println("---------------------------------------------------------");
        System.out.println("C'nin toplam adim sayisi="+atilan_adim_sayisi_C);
        System.out.println("C'nin kasadaki altin miktari="+Player_C_Altin);
        System.out.println("C'nin harcadigi altin sayisi="+harcanan_toplam_altin_C);
        System.out.println("C'nin kazandigi altin sayisi="+toplanan_toplam_altin_C);
        System.out.println("---------------------------------------------------------");
        System.out.println("D'nin toplam adim sayisi="+atilan_adim_sayisi_D);
        System.out.println("D'nin kasadaki altin miktari="+Player_D_Altin);
        System.out.println("D'nin harcadigi altin sayisi="+harcanan_toplam_altin_D);
        System.out.println("D'nin kazandigi altin sayisi="+toplanan_toplam_altin_D);
        System.out.println("---------------------------------------------------------");
        
        
        
        bWriter.write("\nA'nin toplam adim sayisi="+atilan_adim_sayisi_A);
        bWriter.write("\nA'nin kasadaki altin miktari="+Player_A_Altin);
        bWriter.write("\nA'nin harcadigi altin sayisi="+harcanan_toplam_altin_A);
        bWriter.write("\nA'nin kazandigi altin sayisi="+toplanan_toplam_altin_A);
        bWriter.write("\n---------------------------------------------------------");
        bWriter.write("\nB'nin toplam adim sayisi="+atilan_adim_sayisi_B);
        bWriter.write("\nB'nin kasadaki altin miktari="+Player_B_Altin);
        bWriter.write("\nB'nin harcadigi altin sayisi="+harcanan_toplam_altin_B);
        bWriter.write("\nB'nin kazandigi altin sayisi="+toplanan_toplam_altin_B);
        bWriter.write("\n---------------------------------------------------------");
        bWriter.write("\nC'nin toplam adim sayisi="+atilan_adim_sayisi_C);
        bWriter.write("\nC'nin kasadaki altin miktari="+Player_C_Altin);
        bWriter.write("\nC'nin harcadigi altin sayisi="+harcanan_toplam_altin_C);
        bWriter.write("\nC'nin kazandigi altin sayisi="+toplanan_toplam_altin_C);
        bWriter.write("\n---------------------------------------------------------");
        bWriter.write("\nD'nin toplam adim sayisi="+atilan_adim_sayisi_D);
        bWriter.write("\nD'nin kasadaki altin miktari="+Player_D_Altin);
        bWriter.write("\nD'nin harcadigi altin sayisi="+harcanan_toplam_altin_D);
        bWriter.write("\nD'nin kazandigi altin sayisi="+toplanan_toplam_altin_D);
        bWriter.write("\n---------------------------------------------------------");
        
        bWriter.close();
    }

    static void Yazdir(int[][] harita) {
        for (int i = 0; i < harita.length; i++) {
            for (int j = 0; j < harita[0].length; j++) {
                System.out.print("  " + harita[i][j] + " ");

            }
            System.out.println();
        }

    }

    static boolean oyun_devam(int[][] harita) {
        boolean dondur = false;
        for (int i = 0; i < harita.length; i++) {
            for (int j = 0; j < harita[0].length; j++) {
                if (harita[i][j] > 0 && harita[i][j] < 21) {
                    dondur = true;
                }

            }

        }
        return dondur;
    }

    static boolean B_Hedef_belirledi(int[][] harita, int x, int y) {
        boolean dondur = false;

        if (harita[x][y] > 0 && harita[x][y] < 21) {
            dondur = true;
        }
        return dondur;
    }

    static boolean C_Hedef_belirledi(int[][] harita, int x, int y) {
        boolean dondur = false;

        if (harita[x][y] > 0 && harita[x][y] < 21) {
            dondur = true;
        }
        return dondur;
    }

    static boolean D_Hedef_belirledi(int[][] harita, int x, int y) {
        boolean dondur = false;

        if (harita[x][y] > 0 && harita[x][y] < 21) {
            dondur = true;
        }
        return dondur;
    }

    static boolean A_Hedef_belirledi(int[][] harita, int x, int y) {
        boolean dondur = false;

        if (harita[x][y] > 0 && harita[x][y] < 21) {
            dondur = true;
        }
        return dondur;
    }
}
