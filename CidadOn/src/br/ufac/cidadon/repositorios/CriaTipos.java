package br.ufac.cidadon.repositorios;


import java.awt.Image;
import java.awt.Label;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ufac.cidadon.entidades.Problema;
import br.ufac.cidadon.entidades.TipoDeProblema;
import br.ufac.cidadon.entidades.Usuario;
import br.ufac.cidadon.repositorios.ProblemaRepositorio;
import br.ufac.cidadon.repositorios.TipoDeProblemaRepositorio;
import br.ufac.cidadon.repositorios.UsuarioRepositorio;

public class CriaTipos {
	public static void main(String[] args) throws IOException {
		TipoDeProblemaRepositorio tr = new TipoDeProblemaRepositorio();
		//Declarações
		TipoDeProblema [] tiposDeProblema = new TipoDeProblema[5];
		byte[][] todos  = new byte[5][];;
		File [] files = new File [5];
		FileInputStream inputFile;
		String [] titulos = {"Estrutura Viaria","Iluminação Publica","Rede de Distribuição de Água","Rede Elétrica","Rede de Esgoto"};
		String [] descricoes = {"Problemas relacionados as condições das vias públicas. Ex: buracos, inexistência de asfalto.",
								"Problemas relacionados as condições ou inexistência de iluminação publica. Ex: poste sem lâmpada.",
								"Problemas relacionados as condições ou inexistencia da rede de distribuição de água. Ex: falta de água, cano vazando.",
								"Problemas relacionados as condições ou inexistência da rede elétrica. Ex: fio quebrado, poste caido.",
								"Problemas relacionados as condições ou inexistencia da rede de esgoto. Ex: esgoto á céu aberto, boeiro vazando."};
		int [] visibilidades = {2,3,3,2,2};
		//Carregando imagens para os files
		files[0] = new File("img/estruturaViaria.png");
		files[1] = new File("img/iluminacaoPublica.png");
		files[2] = new File("img/redeDistribuicaoAgua.png");
		files[3] = new File("img/redeEletrica.png");
		files[4] = new File("img/redeEsgoto.png");
		//Definindo tamnho dos vetores de bytes
		for(int i=0;i<5;i++) {
			inputFile = new FileInputStream(files[i]);
			todos[i] = new byte[(int) files[i].length()];
			inputFile.read(todos[i]);
			inputFile.close();
			tiposDeProblema[i] = new TipoDeProblema();
			tiposDeProblema[i].setIcone(todos[i]);
			tiposDeProblema[i].setTitulo(titulos[i]);
			tiposDeProblema[i].setDescricao(descricoes[i]);
			tiposDeProblema[i].setMesesVisibilidade(visibilidades[i]);
			tr.adicionar(tiposDeProblema[i]);			
		}
		
		
		
		
//		TipoDeProblema t = tr.recuperar(1);
//		
//		
//		ImageIcon ii = new ImageIcon(t.getIcone());
//		
//		JFrame frame = new JFrame();
//		frame.add(new JLabel(ii));
//		frame.setVisible(true);
//		inputFile.close();
	}	
}
