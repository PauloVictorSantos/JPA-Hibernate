package br.jus.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.jus.hibernate.model.Veiculo;

public class ListandoVeiculos {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createQuery("from Veiculo");
		List<Veiculo> veiculos = query.getResultList();

		for (Veiculo veiculo : veiculos) {
			
			
			System.out.println(veiculo.getId().getPlaca() + " - " + veiculo.getFabricante() + " " + veiculo.getModelo()
					+ ", ano " + veiculo.getAnoFabricacao() + "/" + veiculo.getAnoModelo() + " por " + "R$"
					+ veiculo.getValor());
			
			if(veiculo.getFoto()!=null){
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
			}else{
				System.out.println("este veiculo não tem imagem");
			}
				
			System.out.println(
					veiculo.getEspecificacao() == null ? "veiculo não tem especificação" : "Especificação:\n"+veiculo.getEspecificacao());
			
			
			System.out.println("-----------");
		}

		manager.close();
		JpaUtil.close();

	}

}
