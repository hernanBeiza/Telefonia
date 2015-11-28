/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import telefonia.Android;

import telefonia.Comerciales;
import telefonia.Compania;
import telefonia.PlanTelefonico;
import telefonia.Privado;
import telefonia.IOS;
import telefonia.Telefonia;
import telefonia.Tradicional;
import telefonia.Usuario;

/**
 *
 * @author Andres
 */
public class FonoEditarFrame extends Ventana {

    private Telefonia fonoViejo;
    
    /**
     * Creates new form AgregarTelefonia
     */
    private String tradicionalTipo = "";
    
    public FonoEditarFrame() {
        initComponents();
        iniciarCentrada();
        jPOpciones.setVisible(false);
        cargarInfoCompania();
        cargarMarcasAndroid();
        cargarDatosMovil();
        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        TxtFono.setEditable(false);
    }
    
    private void bloquearTab(int indice){
        TabSmart.setEnabledAt(indice, false);
        JPanel panel = null;
        switch(indice){
            case 0:
                panel = JPPrivado;
                break;
            case 1:
                panel = JPComercial;
                break;
            case 2:
                panel = JPSmartphone;
            break;
            case 3:
                panel = JPTradicional;
                break;
        }
        for (Component component : panel.getComponents()) {
            //System.out.println(component);
            Component unComponente = component;
            unComponente.setEnabled(false);
        }
    }
    
    private void desbloquearTab(int indice){
        TabSmart.setEnabledAt(indice, true);
        TabSmart.setSelectedIndex(indice);
        JPanel panel = null;
        switch(indice){
            case 0:
                panel = JPPrivado;
                break;
            case 1:
                panel = JPComercial;
                break;
            case 2:
                panel = JPSmartphone;
            break;
            case 3:
                panel = JPTradicional;
                break;
        }
  
        for (Component component : panel.getComponents()) {
            //System.out.println(component);
            Component unComponente = component;
            unComponente.setEnabled(true);
        }        
    }
    
    private void cargarDatosMovil(){
        //Peso
        int[] pesos = obtenerDB().getPesos();
        DefaultComboBoxModel mdlPeso = (DefaultComboBoxModel)cboPeso.getModel();
        DefaultComboBoxModel mdlPesoTradiciona = (DefaultComboBoxModel)cboTradicionalPeso.getModel();

        cboPeso.removeAllItems();
        cboTradicionalPeso.removeAllItems();
        
        for (int peso : pesos) {
            mdlPeso.addElement(String.valueOf(peso));
            mdlPesoTradiciona.addElement(String.valueOf(peso));
        }
    }
    
    public void cargarIOS(IOS ios){
        System.out.println("Cargar iOS");
        
        cargarOSiPhone();

        fonoViejo = ios;
        cargar(fonoViejo);
        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        desbloquearTab(2);

        jPOpciones.setVisible(true);        
        
       iPhoneRadioButton.setSelected(true);
       cboModelo.setSelectedItem(String.valueOf(ios.getModelo()));
       cboMemoria.setSelectedItem(String.valueOf(ios.getCantidadmemoria()));
       cboOS.setSelectedItem(String.valueOf(ios.getVersionSO()));
       cboCodigoAntena.setSelectedItem(String.valueOf(ios.getCodigoAntena()));
       cboPeso.setSelectedItem(String.valueOf(ios.getPeso()));
       cboDuracion.setSelectedItem(String.valueOf(ios.getDuracionBateria()));

       cboMarcaAndroid.setEnabled(false);
    }
    
    public void cargarAndroid(Android android){
        System.out.println("Cargar Android");
        
        fonoViejo = android;
        
        cargar(fonoViejo);
        
        cargarOSAndroid();
        
        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        desbloquearTab(2);

        androidRadioButton.setSelected(true);
        jPOpciones.setVisible(true);        
        cboMarcaAndroid.setEnabled(true);
        cboModelo.setEnabled(false);
        
        cboMarcaAndroid.setSelectedItem(String.valueOf(android.getMarcaFono()));
        cboMemoria.setSelectedItem(String.valueOf(android.getCantidadmemoria()));
        cboOS.setSelectedItem(String.valueOf(android.getVersionSO()));
        cboCodigoAntena.setSelectedItem(String.valueOf(android.getCodigoAntena()));
        cboPeso.setSelectedItem(String.valueOf(android.getPeso()));
        cboDuracion.setSelectedItem(String.valueOf(android.getDuracionBateria()));

    }
    
    
    public void cargarTradicional(Tradicional tradicional){
        System.out.println("cargarTradicional");
        
        fonoViejo = tradicional;
        
        cargar(fonoViejo);
        
        cargarOSAndroid();
        
        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        desbloquearTab(3);
        
        if(tradicional.isPantallaColor()){
            cboPantallaColor.setSelectedItem("SI");
        } else {
            cboPantallaColor.setSelectedItem("NO");
        }
        //    private String[] tipos = {"Almeja","Normal","Slider"};

        switch(tradicional.getTipoFono()){
            case "Almeja":
                almejaRadioButton.setSelected(true);
                break;  
            case "Normal":
                normalRadioButton.setSelected(true);
                break;
            case "Slice":
                sliderRadioButton.setSelected(true);
                break;
        }
        cboTradicionalAntena.setSelectedItem(String.valueOf(tradicional.getCodigoAntena()));
        cboTradicionalPeso.setSelectedItem(String.valueOf(tradicional.getPeso()));
        cboTradicionalBateria.setSelectedItem(String.valueOf(tradicional.getDuracionBateria()));
        
    }
    
    
    
    public void cargarPrivado(Privado privado){
        System.out.println("cargarPrivado");
        fonoViejo = privado;
        cargar(fonoViejo);

        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        desbloquearTab(0);

        txtCodigoZona.setText(String.valueOf(privado.getCodigoZona()));
        if(privado.isIdentificadorLlamada()){
            CmbIdeLlamadas.setSelectedIndex(0);
        } else {
            CmbIdeLlamadas.setSelectedIndex(1);
        }
    }
    
    public void cargarComercial(Comerciales comercial){
        System.out.println("cargarComercial");
        fonoViejo = comercial;
        cargar(fonoViejo);
        bloquearTab(0);
        bloquearTab(1);
        bloquearTab(2);
        bloquearTab(3);
        desbloquearTab(1);
        txtCodigoZonaComercial1.setText(String.valueOf(comercial.getCodigoZona()));
        txtCantidadAnexos.setText(String.valueOf(comercial.getCantidadAnexos()));       
    }
    
    private void cargar(Telefonia telefonia){
        TxtFono.setText(telefonia.getNumeroFono());
        TxtRut.setText(telefonia.getUsuario().getRun());
        txtComuna.setText(telefonia.getComuna());
        cboRegion.setSelectedItem(telefonia.getRegion());
        cboCompania.setSelectedItem(telefonia.getCompania().getNombre());
        CmbPlanTelefonico.setSelectedItem(telefonia.getPlanTelefonico().getNombrePlan());
        TxtValorMinutoFijo.setText(String.valueOf(telefonia.getValorMinutoFijo()));
        TxtValorMinutoMovil.setText(String.valueOf(telefonia.getValorMinutoMovil()));
        int tarijaFija = ((int) telefonia.getTarifaFija());
        String tarifa = String.valueOf(tarijaFija);
        TxtTarifaFija.setText(tarifa);
        TxtMinutosUsadosFijo.setText(String.valueOf(telefonia.getCantidadMinutosUsadosFijos()));
        TxtMinutosUsadosMovil.setText(String.valueOf(telefonia.getCantidadMinutosUsadosMovil()));
        TxtCostoEquipo.setText(String.valueOf(telefonia.getCostoEquipo()));
        TxtFechadeContrato.setText(String.valueOf(telefonia.getFechaContrato()));
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        SmarthGroup = new javax.swing.ButtonGroup();
        tipoTradicionalButtonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblCompañia = new javax.swing.JLabel();
        cboCompania = new javax.swing.JComboBox();
        LblRut = new javax.swing.JLabel();
        TxtRut = new javax.swing.JTextField();
        LblFono = new javax.swing.JLabel();
        TxtFono = new javax.swing.JTextField();
        LblNombre = new javax.swing.JLabel();
        LblComuna = new javax.swing.JLabel();
        txtComuna = new javax.swing.JTextField();
        LblRegion = new javax.swing.JLabel();
        LblContrato = new javax.swing.JLabel();
        TxtFechadeContrato = new javax.swing.JTextField();
        LblCosto = new javax.swing.JLabel();
        TxtCostoEquipo = new javax.swing.JTextField();
        LblPlanT = new javax.swing.JLabel();
        CmbPlanTelefonico = new javax.swing.JComboBox();
        cboRegion = new javax.swing.JComboBox();
        TabSmart = new javax.swing.JTabbedPane();
        JPPrivado = new javax.swing.JPanel();
        LblIdentifLlamadas = new javax.swing.JLabel();
        CmbIdeLlamadas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoZona = new javax.swing.JTextField();
        JPComercial = new javax.swing.JPanel();
        LblCantidadAnexos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadAnexos = new javax.swing.JTextField();
        txtCodigoZonaComercial1 = new javax.swing.JTextField();
        JPSmartphone = new javax.swing.JPanel();
        iPhoneRadioButton = new javax.swing.JRadioButton();
        androidRadioButton = new javax.swing.JRadioButton();
        jPOpciones = new javax.swing.JPanel();
        lblModelo = new javax.swing.JLabel();
        LblMemoriaIphone = new javax.swing.JLabel();
        LblSop = new javax.swing.JLabel();
        LblSop1 = new javax.swing.JLabel();
        LblPeso = new javax.swing.JLabel();
        LblDuracionBateria = new javax.swing.JLabel();
        LblMarca = new javax.swing.JLabel();
        cboModelo = new javax.swing.JComboBox();
        cboMemoria = new javax.swing.JComboBox();
        cboOS = new javax.swing.JComboBox();
        cboCodigoAntena = new javax.swing.JComboBox();
        cboPeso = new javax.swing.JComboBox();
        cboDuracion = new javax.swing.JComboBox();
        cboMarcaAndroid = new javax.swing.JComboBox();
        JPTradicional = new javax.swing.JPanel();
        LblPantallaColor = new javax.swing.JLabel();
        cboPantallaColor = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        LblSop2 = new javax.swing.JLabel();
        cboTradicionalAntena = new javax.swing.JComboBox();
        LblPeso1 = new javax.swing.JLabel();
        cboTradicionalPeso = new javax.swing.JComboBox();
        LblDuracionBateria1 = new javax.swing.JLabel();
        cboTradicionalBateria = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        normalRadioButton = new javax.swing.JRadioButton();
        sliderRadioButton = new javax.swing.JRadioButton();
        almejaRadioButton = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        LblValorMinutoFijo1 = new javax.swing.JLabel();
        TxtValorMinutoFijo = new javax.swing.JTextField();
        LblValorMinutoMovil1 = new javax.swing.JLabel();
        TxtValorMinutoMovil = new javax.swing.JTextField();
        LblTarifaFija1 = new javax.swing.JLabel();
        LblMinutosUsadosFijo1 = new javax.swing.JLabel();
        TxtMinutosUsadosFijo = new javax.swing.JTextField();
        TxtTarifaFija = new javax.swing.JTextField();
        LblMinutosUsadosMovil1 = new javax.swing.JLabel();
        TxtMinutosUsadosMovil = new javax.swing.JTextField();
        BtnCerrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESO TELEFONIA");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCompañia.setText("Compañia");

        cboCompania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCompaniaActionPerformed(evt);
            }
        });

        LblRut.setText("Rut");

        TxtRut.setText("13269946-1");
        TxtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRutActionPerformed(evt);
            }
        });

        LblFono.setText("Numero Telefono ");

        TxtFono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFonoActionPerformed(evt);
            }
        });

        LblComuna.setText("Comuna");

        txtComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComunaActionPerformed(evt);
            }
        });
        txtComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComunaKeyPressed(evt);
            }
        });

        LblRegion.setText("Región");

        LblContrato.setText("Fecha Contrato");

        TxtFechadeContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechadeContratoActionPerformed(evt);
            }
        });

        LblCosto.setText("Costo Equipo");

        TxtCostoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCostoEquipoActionPerformed(evt);
            }
        });

        LblPlanT.setText("Plan Telefonico");

        CmbPlanTelefonico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPlanTelefonicoActionPerformed(evt);
            }
        });

        cboRegion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Libertador General", "Bernardo O'Higgins", "Maule", "Biobío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén del General", "Carlos Ibáñez del Campo", "Magallanes y de la", "Antártica Chilena", "Metropolitana de Santiago" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblFono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFono, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblRut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LblComuna)
                                .addGap(36, 36, 36)
                                .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCompañia)
                                .addGap(28, 28, 28)
                                .addComponent(cboCompania, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LblCosto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtCostoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(LblRegion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblContrato)
                                    .addComponent(LblPlanT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbPlanTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtFechadeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblFono)
                        .addComponent(TxtFono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblRut)
                        .addComponent(LblNombre)
                        .addComponent(TxtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblComuna)
                            .addComponent(txtComuna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompañia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblCosto)
                            .addComponent(TxtCostoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblRegion)
                            .addComponent(cboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbPlanTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblPlanT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblContrato)
                            .addComponent(TxtFechadeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabSmart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabSmart.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TabSmart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabSmartMouseClicked(evt);
            }
        });

        JPPrivado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPPrivado.setEnabled(false);

        LblIdentifLlamadas.setText("Identificador de Llamadas");

        CmbIdeLlamadas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));

        jLabel1.setText("Código Zona");

        javax.swing.GroupLayout JPPrivadoLayout = new javax.swing.GroupLayout(JPPrivado);
        JPPrivado.setLayout(JPPrivadoLayout);
        JPPrivadoLayout.setHorizontalGroup(
            JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPPrivadoLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblIdentifLlamadas)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CmbIdeLlamadas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoZona, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183))
        );
        JPPrivadoLayout.setVerticalGroup(
            JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivadoLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblIdentifLlamadas)
                    .addComponent(CmbIdeLlamadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        TabSmart.addTab("Privado", JPPrivado);
        JPPrivado.getAccessibleContext().setAccessibleParent(JPPrivado);

        JPComercial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPComercial.setEnabled(false);

        LblCantidadAnexos.setText("Cantidad de Anexos");

        jLabel2.setText("Código Zona");

        javax.swing.GroupLayout JPComercialLayout = new javax.swing.GroupLayout(JPComercial);
        JPComercial.setLayout(JPComercialLayout);
        JPComercialLayout.setHorizontalGroup(
            JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPComercialLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoZonaComercial1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        JPComercialLayout.setVerticalGroup(
            JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPComercialLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoZonaComercial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JPComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCantidadAnexos)
                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        TabSmart.addTab("Comercial", JPComercial);
        JPComercial.getAccessibleContext().setAccessibleParent(JPComercial);

        JPSmartphone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPSmartphone.setEnabled(false);

        SmarthGroup.add(iPhoneRadioButton);
        iPhoneRadioButton.setText("iPhone");
        iPhoneRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iPhoneRadioButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                iPhoneRadioButtonMouseReleased(evt);
            }
        });

        SmarthGroup.add(androidRadioButton);
        androidRadioButton.setText("Android");
        androidRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                androidRadioButtonMouseReleased(evt);
            }
        });

        jPOpciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblModelo.setText("Modelo");

        LblMemoriaIphone.setText("Memoria");

        LblSop.setText("Sistema Operativo");

        LblSop1.setText("Codigo Antena");

        LblPeso.setText("Peso");

        LblDuracionBateria.setText("Duración Bateria");

        LblMarca.setText("Marca");

        cboModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6" }));

        cboMemoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "16", "32", "64", "128" }));

        cboCodigoAntena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        cboDuracion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6" }));

        cboMarcaAndroid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "7.0", "8.0", "9.0" }));

        javax.swing.GroupLayout jPOpcionesLayout = new javax.swing.GroupLayout(jPOpciones);
        jPOpciones.setLayout(jPOpcionesLayout);
        jPOpcionesLayout.setHorizontalGroup(
            jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPOpcionesLayout.createSequentialGroup()
                        .addComponent(LblSop1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCodigoAntena, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPOpcionesLayout.createSequentialGroup()
                        .addComponent(LblSop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(cboOS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPOpcionesLayout.createSequentialGroup()
                        .addComponent(LblMemoriaIphone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPOpcionesLayout.createSequentialGroup()
                        .addComponent(LblPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPOpcionesLayout.createSequentialGroup()
                        .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LblDuracionBateria)
                            .addComponent(lblModelo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPOpcionesLayout.createSequentialGroup()
                                .addComponent(LblMarca)
                                .addGap(50, 50, 50)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDuracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMarcaAndroid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        jPOpcionesLayout.setVerticalGroup(
            jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(cboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMemoriaIphone)
                    .addComponent(cboMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSop)
                    .addComponent(cboOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSop1)
                    .addComponent(cboCodigoAntena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPeso)
                    .addComponent(cboPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDuracionBateria)
                    .addComponent(cboDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMarca)
                    .addComponent(cboMarcaAndroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout JPSmartphoneLayout = new javax.swing.GroupLayout(JPSmartphone);
        JPSmartphone.setLayout(JPSmartphoneLayout);
        JPSmartphoneLayout.setHorizontalGroup(
            JPSmartphoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSmartphoneLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(JPSmartphoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(androidRadioButton)
                    .addComponent(iPhoneRadioButton))
                .addGap(86, 86, 86)
                .addComponent(jPOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPSmartphoneLayout.setVerticalGroup(
            JPSmartphoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPSmartphoneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(JPSmartphoneLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(iPhoneRadioButton)
                .addGap(79, 79, 79)
                .addComponent(androidRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabSmart.addTab("SmartPhone", JPSmartphone);

        JPTradicional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPTradicional.setEnabled(false);

        LblPantallaColor.setText("Pantalla Color");

        cboPantallaColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LblSop2.setText("Codigo Antena");

        cboTradicionalAntena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        LblPeso1.setText("Peso");

        LblDuracionBateria1.setText("Duración Bateria");

        cboTradicionalBateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblSop2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTradicionalAntena, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblPeso1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTradicionalPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(LblDuracionBateria1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTradicionalBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblDuracionBateria1)
                        .addComponent(cboTradicionalBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblPeso1)
                        .addComponent(cboTradicionalPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblSop2)
                        .addComponent(cboTradicionalAntena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tipoTradicionalButtonGroup.add(normalRadioButton);
        normalRadioButton.setText("Normal");
        normalRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                normalRadioButtonMouseClicked(evt);
            }
        });

        tipoTradicionalButtonGroup.add(sliderRadioButton);
        sliderRadioButton.setText("Slide");
        sliderRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sliderRadioButtonMouseClicked(evt);
            }
        });

        tipoTradicionalButtonGroup.add(almejaRadioButton);
        almejaRadioButton.setText("Almeja");
        almejaRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                almejaRadioButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(normalRadioButton)
                .addGap(154, 154, 154)
                .addComponent(sliderRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(almejaRadioButton)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalRadioButton)
                    .addComponent(sliderRadioButton)
                    .addComponent(almejaRadioButton))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPTradicionalLayout = new javax.swing.GroupLayout(JPTradicional);
        JPTradicional.setLayout(JPTradicionalLayout);
        JPTradicionalLayout.setHorizontalGroup(
            JPTradicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTradicionalLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(LblPantallaColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPantallaColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
            .addGroup(JPTradicionalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(JPTradicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPTradicionalLayout.setVerticalGroup(
            JPTradicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTradicionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPTradicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPantallaColor)
                    .addComponent(cboPantallaColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabSmart.addTab("Tradicional", JPTradicional);
        JPTradicional.getAccessibleContext().setAccessibleParent(JPTradicional);

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LblValorMinutoFijo1.setText("Valor Minuto Fijo");

        TxtValorMinutoFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValorMinutoFijoActionPerformed(evt);
            }
        });

        LblValorMinutoMovil1.setText("Valor Minuto Movil");

        TxtValorMinutoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValorMinutoMovilActionPerformed(evt);
            }
        });

        LblTarifaFija1.setText("Tarifa Fija");

        LblMinutosUsadosFijo1.setText("Cantidad Minutos Usados Fijos");

        TxtMinutosUsadosFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMinutosUsadosFijoActionPerformed(evt);
            }
        });

        TxtTarifaFija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTarifaFijaActionPerformed(evt);
            }
        });

        LblMinutosUsadosMovil1.setText("Cantidad Minutos Usados Moviles");

        TxtMinutosUsadosMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMinutosUsadosMovilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(LblValorMinutoFijo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtValorMinutoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(LblValorMinutoMovil1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtValorMinutoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(LblTarifaFija1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTarifaFija, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(LblMinutosUsadosFijo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMinutosUsadosFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(LblMinutosUsadosMovil1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMinutosUsadosMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(541, 541, 541))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblValorMinutoFijo1)
                    .addComponent(TxtValorMinutoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblValorMinutoMovil1)
                    .addComponent(TxtValorMinutoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTarifaFija1)
                    .addComponent(TxtTarifaFija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMinutosUsadosFijo1)
                    .addComponent(TxtMinutosUsadosFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMinutosUsadosMovil1)
                    .addComponent(TxtMinutosUsadosMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnCerrar.setText("Cerrar");
        BtnCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Modificar");
        btnEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabSmart))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabSmart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabSmart.getAccessibleContext().setAccessibleName("");
        TabSmart.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        System.out.println("Editar");
        boolean guardar = true;
        String mensajeError = "Le faltaron los siguientes datos:";
        if(TxtRut.getText().equals("")){
            guardar = false;
            mensajeError+="\n Rut";
        }
        if(TxtFono.getText().equals("")){
            guardar = false;
            mensajeError+="\n Telelfono";
        }
        if(txtComuna.getText().equals("")){
            guardar = false;
            mensajeError+="\n Comuna";
        }
       if(TxtCostoEquipo.getText().equals("")){
            guardar = false;
            mensajeError+="\n Costo Equipo";
        }
       if(TxtFechadeContrato.getText().equals("")){
            guardar = false;
            mensajeError+="\n Fecha de Contrato";
        }       
        if(TxtValorMinutoFijo.getText().equals("")){
            guardar = false;
            mensajeError+="\n Valor Minuto Fijo";
        }
        if(TxtValorMinutoMovil.getText().equals("")){
            guardar = false;
            mensajeError+="\n Valor Minuto Movil";
        }
        if(TxtTarifaFija.getText().equals("")){
            guardar = false;
            mensajeError+="\n Tarifa Fija";
        }
        if(TxtMinutosUsadosFijo.getText().equals("")){
            guardar = false;
            mensajeError+="\n Minutos Usados Fijo";
        }
        if(TxtMinutosUsadosMovil.getText().equals("")){
            guardar = false;
            mensajeError+="\n Minutos Usados Movil";
        }
        if(TxtValorMinutoFijo.getText().equals("")){
            guardar = false;
            mensajeError+="\n Valor Minutos Fijo";
        }
        if(TxtValorMinutoMovil.getText().equals("")){
            guardar = false;
            mensajeError+="\n Valor Minutos Movil";
        }
        if(TxtTarifaFija.getText().equals("")){
            guardar = false;
            mensajeError+="\n Tarifa Fija";
        }
        if(TxtMinutosUsadosFijo.getText().equals("")){
            guardar = false;
            mensajeError+="\n Tarifa Fija";
        }        
        if(TxtMinutosUsadosMovil.getText().equals("")){
            guardar = false;
            mensajeError+="\n Tarifa Fija";
        }        
         
        
        Usuario usuario = obtenerDB().usuarioBuscarPorRut(TxtRut.getText());
        
        if(usuario == null){
            guardar = false;
            mensajeError+="\n Usuario no encontrado";            
        }
        
        if(guardar){
            System.out.println("Data requerida");
            //Data en común para todos los móviles                         
            fonoViejo.setComuna(txtComuna.getText());
            fonoViejo.setRegion(cboRegion.getSelectedItem().toString());
                        
            fonoViejo.setCostoEquipo(Integer.parseInt(TxtCostoEquipo.getText()));
            fonoViejo.setFechaContrato(TxtFechadeContrato.getText());
            System.out.println("Fecha contrato " + fonoViejo.getFechaContrato());
            fonoViejo.setValorMinutoFijo(Integer.parseInt(TxtValorMinutoFijo.getText()));
            fonoViejo.setValorMinutoMovil(Integer.parseInt(TxtValorMinutoMovil.getText()));
            fonoViejo.setTarifaFija(Integer.parseInt(TxtTarifaFija.getText()));
            fonoViejo.setCantidadMinutosUsadosFijos(Integer.parseInt(TxtMinutosUsadosFijo.getText()));
            fonoViejo.setCantidadMinutosUsadosMovil(Integer.parseInt(TxtMinutosUsadosMovil.getText()));
            
            String numero = this.TxtFono.getText();
            String numeroTelefono = TxtFono.getText();
            String rut = TxtRut.getText();

            String comuna = txtComuna.getText();
            String region = cboRegion.getSelectedItem().toString().toUpperCase();                
            System.out.println(region);
            // tomo indice de combo
            int IndCom = cboCompania.getSelectedIndex();
            //Repasa dato completo  
            Compania  compania =  obtenerDB().companiaObtener().get(IndCom);
            System.out.println(compania);
            fonoViejo.setCompania(compania);
            int IndPlan = CmbPlanTelefonico.getSelectedIndex();                
            //Obtener plan teléfono de la companía seleccionada
            PlanTelefonico planTelefonico = compania.getPlan().get(IndPlan);
            System.out.println(planTelefonico);
            fonoViejo.setPlanTelefonico(planTelefonico);
            int costoEquipo = Integer.parseInt(TxtCostoEquipo.getText());

            int valorMinutoFijo = Integer.parseInt(TxtValorMinutoFijo.getText());
            int valorMinutoMovil =  Integer.parseInt(TxtValorMinutoMovil.getText());
            int tarifaFija = Integer.parseInt(TxtTarifaFija.getText());
            int cantidadMinutosFijos = Integer.parseInt(TxtMinutosUsadosFijo.getText());
            int cantidadMinutosMoviles = Integer.parseInt(TxtMinutosUsadosMovil.getText());

            if (obtenerDB().telefonosEsMovil(numero)){
                System.out.println("Telefono Movil");

                String versionOS = "";
                int codigoAntena = 0;
                int peso = 0;
                int duracionBateria = 0;

                if (TabSmart.getSelectedIndex()==2){
                    System.out.println("Smartphone");
                    //Validar smartphone
                    //Memoria
                    int cantidadMemoria =Integer.parseInt(cboMemoria.getSelectedItem().toString());

                    if(!iPhoneRadioButton.isSelected() && !androidRadioButton.isSelected()){
                        mensajeError +="Elegir un tipo de smartphone";
                    }
                    //peso móvil
                    peso = Integer.parseInt(cboPeso.getSelectedItem().toString());
                    //duracion
                    duracionBateria = Integer.parseInt(cboDuracion.getSelectedItem().toString());
                    //Sistema Operativo
                    versionOS = cboOS.getSelectedItem().toString();
                    //Código antena
                    codigoAntena = Integer.parseInt(cboCodigoAntena.getSelectedItem().toString());

                    System.out.println("codigoAntena " + codigoAntena);
                    System.out.println("versionOS " + versionOS);
                    System.out.println("cantidadMemoria " + cantidadMemoria);

                    if (iPhoneRadioButton.isSelected() == true){
                        System.out.println("ios");
                        //Modelo
                        String modelo = cboModelo.getSelectedItem().toString();
                        System.out.println("modelo " + modelo);
                        IOS ios = (IOS)fonoViejo;
                        ios.setCodigoAntena(codigoAntena);
                        ios.setModelo(modelo);
                        ios.setVersionSO(versionOS);
                        ios.setPeso(peso);
                        ios.setDuracionBateria(duracionBateria);
                        ios.setCantidadmemoria(cantidadMemoria);                        
                        JOptionPane.showMessageDialog(rootPane, "Número guardado correctamente", "Guardado correcto", JOptionPane.INFORMATION_MESSAGE);
                        LimpiaFono();
                    }else{
                        System.out.println("Android");
                        //Marca
                        String marca = cboMarcaAndroid.getSelectedItem().toString();
                        System.out.println("marca " + marca);
                        Android android = (Android)fonoViejo;
                        android.setCodigoAntena(codigoAntena);
                        android.setMarcaFono(marca);
                        android.setVersionSO(versionOS);
                        android.setPeso(peso);
                        android.setDuracionBateria(duracionBateria);
                        android.setCantidadmemoria(cantidadMemoria);                        
                        JOptionPane.showMessageDialog(rootPane, "Número guardado correctamente", "Guardado correcto", JOptionPane.INFORMATION_MESSAGE);
                        LimpiaFono();
                    }

                } else if (TabSmart.getSelectedIndex()==3){
                    System.out.println("Tradicional");
                    String pantallaColor = cboPantallaColor.getSelectedItem().toString();
                    boolean pantalla = false;
                    if(pantallaColor.equals("SI")){
                        pantalla = true;
                    }
                    if(almejaRadioButton.isSelected()){
                        tradicionalTipo = "Almeja";   
                    }else if(sliderRadioButton.isSelected()){
                        tradicionalTipo = "Slice";
                    } else {
                        tradicionalTipo = "Normal";
                    }
                    System.out.println("tradicionalTipo " + tradicionalTipo);
                    //peso móvil
                    peso = Integer.parseInt(cboTradicionalPeso.getSelectedItem().toString());
                    //duracion
                    duracionBateria = Integer.parseInt(cboTradicionalBateria.getSelectedItem().toString());
                    //Código antena
                    codigoAntena = Integer.parseInt(cboTradicionalAntena.getSelectedItem().toString());
                    System.out.println("peso " + peso);
                    System.out.println("codigoAntena " + codigoAntena);
                    Tradicional tradicional = (Tradicional)fonoViejo;
                    tradicional.setCodigoAntena(codigoAntena);
                    tradicional.setDuracionBateria(duracionBateria);
                    tradicional.setPantallaColor(pantalla);
                    tradicional.setTipoFono(tradicionalTipo);
                    //Crear
                    JOptionPane.showMessageDialog(rootPane, "Número guardado correctamente", "Guardado correcto", JOptionPane.INFORMATION_MESSAGE);
                    LimpiaFono();
                }
            }else{
                System.out.println("Telefono Fijo");
                int codigoZona = Integer.parseInt(txtCodigoZona.getText());
                System.out.println("codigoZona " + codigoZona);

                if (TabSmart.getSelectedIndex()==0){
                    System.out.println("privado");
                    int Identif = CmbIdeLlamadas.getSelectedIndex();
                    String  Id = CmbIdeLlamadas.getSelectedItem().toString();
                    Boolean Identificador = false;
                    if (Id.equals("SI")){
                        Identificador = true;
                    }
                    //Actualizar
                    Privado elPrivado = (Privado)fonoViejo;
                    elPrivado.setIdentificadorLlamada(Identificador);
                    elPrivado.setCodigoZona(codigoZona);
                    JOptionPane.showMessageDialog(null, "Número modificado correctamente");
                    LimpiaFono();                        
                }else{
                    System.out.println("Teléfono comercial");
                    int cantidadAnexos = Integer.parseInt(txtCantidadAnexos.getText());
                    //Actualizar
                    Comerciales comercial = (Comerciales)fonoViejo;
                    comercial.setCantidadAnexos(cantidadAnexos);
                    comercial.setCostoEquipo(costoEquipo);
                    comercial.setCodigoZona(codigoZona);
                    System.out.println(comercial.toString());                        
                    JOptionPane.showMessageDialog(null, "Número modificado correctamente");
                    LimpiaFono();
                }   
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, mensajeError, "Error al intentar guardar", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void CmbPlanTelefonicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPlanTelefonicoActionPerformed
        // TODO add your handling code here:
        CmbPlanTelefonico.transferFocus();
    }//GEN-LAST:event_CmbPlanTelefonicoActionPerformed

    private void TxtCostoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCostoEquipoActionPerformed
        // TODO add your handling code here:
        TxtCostoEquipo.transferFocus();
    }//GEN-LAST:event_TxtCostoEquipoActionPerformed

    private void TxtFechadeContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechadeContratoActionPerformed
        // TODO add your handling code here:
        TxtFechadeContrato.transferFocus();
    }//GEN-LAST:event_TxtFechadeContratoActionPerformed

    private void txtComunaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComunaKeyPressed
        // TODO add your handling code here:
        //               TransformaMayuscula(TxtComuna.getText());

    }//GEN-LAST:event_txtComunaKeyPressed

    private void txtComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComunaActionPerformed
        // TODO add your handling code here:}
        this.txtComuna.transferFocus();
        String Comuna = this.txtComuna.getText();
        this.txtComuna.setText(Comuna.toUpperCase());
    }//GEN-LAST:event_txtComunaActionPerformed

    private void TxtFonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFonoActionPerformed
        // TODO add your handling code here:
        this.TxtFono.transferFocus();
        String numero = this.TxtFono.getText();
        if (obtenerDB().telefonosEsMovil(numero)){
            bloquearTab(0);
            bloquearTab(1);
            desbloquearTab(2);
            desbloquearTab(3);
        } else {
            desbloquearTab(0);
            desbloquearTab(1);
            bloquearTab(2);
            bloquearTab(3);
        }
    }//GEN-LAST:event_TxtFonoActionPerformed

    private void TxtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRutActionPerformed
        this.TxtRut.transferFocus();
        //int NomUsu = CmbCompañia.getSelectedIndex();
        String RutUsu = TxtRut.getText();
        Usuario Obj_Usuario = obtenerDB().usuarioBuscarPorRut(RutUsu);
        System.out.println(Obj_Usuario);

        if (Obj_Usuario !=null){
            String Nombre = Obj_Usuario.getNombre() +" "+Obj_Usuario.getApellido();
            System.out.println("Nombre Usuario "+Nombre);
            LblNombre.setText(Nombre);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se encontro Usuario", "Error al Realizar la Busiqueda", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_TxtRutActionPerformed

    private void cboCompaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCompaniaActionPerformed
        // TODO add your handling code here:
        cboCompania.transferFocus();
        CmbPlanTelefonico.removeAllItems();
        int NomCom = cboCompania.getSelectedIndex();
        Compania Paso = obtenerDB().companiaObtener().get(NomCom);

        DefaultComboBoxModel mdlCombo= (DefaultComboBoxModel)CmbPlanTelefonico.getModel();
        Iterator it = Paso.getPlan().iterator();
        int rowCount = mdlCombo.getSize();
        for (int i = rowCount - 1; i >= 0; i--) {
            mdlCombo.removeElement(i);
        }
        while(it.hasNext()){
            PlanTelefonico plan = (PlanTelefonico)it.next();
            String NombrePlan = plan.getNombrePlan();
            mdlCombo.addElement(NombrePlan);
            //System.out.println("nombre plan "+plan.getNombrePlan());
        }
    }//GEN-LAST:event_cboCompaniaActionPerformed

    private void TxtMinutosUsadosMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMinutosUsadosMovilActionPerformed
        // TODO add your handling code here:
        TxtMinutosUsadosMovil.transferFocus();
    }//GEN-LAST:event_TxtMinutosUsadosMovilActionPerformed

    private void TxtTarifaFijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTarifaFijaActionPerformed
        // TODO add your handling code here:
        TxtTarifaFija.transferFocus();
    }//GEN-LAST:event_TxtTarifaFijaActionPerformed

    private void TxtMinutosUsadosFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMinutosUsadosFijoActionPerformed
        // TODO add your handling code here:
        TxtMinutosUsadosFijo.transferFocus();
    }//GEN-LAST:event_TxtMinutosUsadosFijoActionPerformed

    private void TxtValorMinutoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValorMinutoMovilActionPerformed
        // TODO add your handling code here:
        TxtValorMinutoMovil.transferFocus();
    }//GEN-LAST:event_TxtValorMinutoMovilActionPerformed

    private void TxtValorMinutoFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValorMinutoFijoActionPerformed
        // TODO add your handling code here:
        TxtValorMinutoFijo.transferFocus();

    }//GEN-LAST:event_TxtValorMinutoFijoActionPerformed

    private void TabSmartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabSmartMouseClicked
        // TODO add your handling code here:
        JPPrivado.setName(null);
    }//GEN-LAST:event_TabSmartMouseClicked

    private void almejaRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_almejaRadioButtonMouseClicked
        // TODO add your handling code here:
        tradicionalTipo = "Almeja";
    }//GEN-LAST:event_almejaRadioButtonMouseClicked

    private void sliderRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderRadioButtonMouseClicked
        // TODO add your handling code here:
        tradicionalTipo = "Slider";
    }//GEN-LAST:event_sliderRadioButtonMouseClicked

    // Tipo de móvil tradicioanl
    private void normalRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_normalRadioButtonMouseClicked
        // TODO add your handling code here:
        tradicionalTipo = "Normal";
    }//GEN-LAST:event_normalRadioButtonMouseClicked

    private void androidRadioButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_androidRadioButtonMouseReleased
        // TODO add your handling code here:
        //cargar OS Android
        cargarOSAndroid();
        this.cboMarcaAndroid.setEnabled(true);       
        this.cboModelo.setEnabled(false);
    }//GEN-LAST:event_androidRadioButtonMouseReleased

    private void iPhoneRadioButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iPhoneRadioButtonMouseReleased
        // TODO add your handling code here:
        cargarOSiPhone();
        this.cboModelo.setEnabled(true);
        this.cboMarcaAndroid.setEnabled(false);
    }//GEN-LAST:event_iPhoneRadioButtonMouseReleased

    private void iPhoneRadioButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iPhoneRadioButtonMousePressed
        // TODO add your handling code here:
        jPOpciones.setVisible(true);
    }//GEN-LAST:event_iPhoneRadioButtonMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FonoEditarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FonoEditarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FonoEditarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FonoEditarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FonoEditarFrame().setVisible(true);
            }
        });
    }
 
   private void cargarInfoCompania(){
       ArrayList <Compania> compania = obtenerDB().companiaObtener();
        System.out.println(compania.toString());
        if(compania.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No se encontraron planes", "Error al intentar listar", JOptionPane.WARNING_MESSAGE);
        } else {
            DefaultComboBoxModel mdlCombo= (DefaultComboBoxModel)cboCompania.getModel();
            Iterator it = compania.iterator();
            int rowCount = mdlCombo.getSize();
            for (int i = rowCount - 1; i >= 0; i--) {
                mdlCombo.removeElement(i);
            }
            while(it.hasNext()){
                Compania Obj_Compania = (Compania)it.next();
                String Comp = Obj_Compania.getNombre();
                mdlCombo.addElement(Comp);
             }
        }
    }
   private void LimpiaFono(){
                TxtFono.setText(null);
                TxtRut.setText(null);
                TxtCostoEquipo.setText(null);
                txtCodigoZona.setText(null);
                txtCodigoZonaComercial1.setText(null);
                txtCantidadAnexos.setText(null);
                txtComuna.setText(null);
                TxtFechadeContrato.setText(null);
                TxtValorMinutoFijo.setText(null);
                TxtValorMinutoMovil.setText(null);
                TxtTarifaFija.setText(null);
                TxtMinutosUsadosFijo.setText(null);
                TxtMinutosUsadosMovil.setText(null);
                LblNombre.setText(null);
   }
   private void cargarMarcasAndroid(){
        String[] marcas = obtenerDB().getMarcasAndroid();
        DefaultComboBoxModel mdlCombo= (DefaultComboBoxModel)cboMarcaAndroid.getModel();
        cboMarcaAndroid.removeAllItems();
        for (String marca : marcas) {
            mdlCombo.addElement(marca);
        }
    }
   
   private void cargarOSAndroid(){
        String[] versiones = obtenerDB().getVersionesAndroid();
        DefaultComboBoxModel mdlCombo= (DefaultComboBoxModel)cboOS.getModel();
        cboOS.removeAllItems();
        for (String marca : versiones) {
            mdlCombo.addElement(marca);
        }
    }
   private void cargarOSiPhone(){
        String[] versiones = obtenerDB().getVersionesiOS();
        DefaultComboBoxModel mdlCombo= (DefaultComboBoxModel)cboOS.getModel();
        cboOS.removeAllItems();
        for (String marca : versiones) {
            mdlCombo.addElement(marca);
        }
    }
   
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JComboBox CmbIdeLlamadas;
    private javax.swing.JComboBox CmbPlanTelefonico;
    private javax.swing.JPanel JPComercial;
    private javax.swing.JPanel JPPrivado;
    private javax.swing.JPanel JPSmartphone;
    private javax.swing.JPanel JPTradicional;
    private javax.swing.JLabel LblCantidadAnexos;
    private javax.swing.JLabel LblComuna;
    private javax.swing.JLabel LblContrato;
    private javax.swing.JLabel LblCosto;
    private javax.swing.JLabel LblDuracionBateria;
    private javax.swing.JLabel LblDuracionBateria1;
    private javax.swing.JLabel LblFono;
    private javax.swing.JLabel LblIdentifLlamadas;
    private javax.swing.JLabel LblMarca;
    private javax.swing.JLabel LblMemoriaIphone;
    private javax.swing.JLabel LblMinutosUsadosFijo1;
    private javax.swing.JLabel LblMinutosUsadosMovil1;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblPantallaColor;
    private javax.swing.JLabel LblPeso;
    private javax.swing.JLabel LblPeso1;
    private javax.swing.JLabel LblPlanT;
    private javax.swing.JLabel LblRegion;
    private javax.swing.JLabel LblRut;
    private javax.swing.JLabel LblSop;
    private javax.swing.JLabel LblSop1;
    private javax.swing.JLabel LblSop2;
    private javax.swing.JLabel LblTarifaFija1;
    private javax.swing.JLabel LblValorMinutoFijo1;
    private javax.swing.JLabel LblValorMinutoMovil1;
    private javax.swing.ButtonGroup SmarthGroup;
    private javax.swing.JTabbedPane TabSmart;
    private javax.swing.JTextField TxtCostoEquipo;
    private javax.swing.JTextField TxtFechadeContrato;
    private javax.swing.JTextField TxtFono;
    private javax.swing.JTextField TxtMinutosUsadosFijo;
    private javax.swing.JTextField TxtMinutosUsadosMovil;
    private javax.swing.JTextField TxtRut;
    private javax.swing.JTextField TxtTarifaFija;
    private javax.swing.JTextField TxtValorMinutoFijo;
    private javax.swing.JTextField TxtValorMinutoMovil;
    private javax.swing.JRadioButton almejaRadioButton;
    private javax.swing.JRadioButton androidRadioButton;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox cboCodigoAntena;
    private javax.swing.JComboBox cboCompania;
    private javax.swing.JComboBox cboDuracion;
    private javax.swing.JComboBox cboMarcaAndroid;
    private javax.swing.JComboBox cboMemoria;
    private javax.swing.JComboBox cboModelo;
    private javax.swing.JComboBox cboOS;
    private javax.swing.JComboBox cboPantallaColor;
    private javax.swing.JComboBox cboPeso;
    private javax.swing.JComboBox cboRegion;
    private javax.swing.JComboBox cboTradicionalAntena;
    private javax.swing.JComboBox cboTradicionalBateria;
    private javax.swing.JComboBox cboTradicionalPeso;
    private javax.swing.JRadioButton iPhoneRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPOpciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCompañia;
    private javax.swing.JLabel lblModelo;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JRadioButton normalRadioButton;
    private javax.swing.JRadioButton sliderRadioButton;
    private javax.swing.ButtonGroup tipoTradicionalButtonGroup;
    private javax.swing.JTextField txtCantidadAnexos;
    private javax.swing.JTextField txtCodigoZona;
    private javax.swing.JTextField txtCodigoZonaComercial1;
    private javax.swing.JTextField txtComuna;
    // End of variables declaration//GEN-END:variables
}
