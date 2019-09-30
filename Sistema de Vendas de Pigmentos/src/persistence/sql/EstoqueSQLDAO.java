package persistence.sql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Estoque;
import model.Pigmento;
import model.PigmentoCMYK;
import model.PigmentoRGB;
import persistence.EstoqueDAO;

public class EstoqueSQLDAO extends ConnectionDAO implements EstoqueDAO {
	
	private static final String SELECT_PIGMENTO_RGB = 
			"SELECT nome, idPigmento, qtdNoEstoque, preco, red, green, blue FROM pigmentorgb WHERE qtdNoEstoque >= ?";
	
	private static final String SELECT_PIGMENTO_CMYK = 
			"SELECT nome, idPigmento, qtdNoEstoque, preco, cyan, magenta, yellow, keyblack  FROM pigmentocmyk WHERE qtdNoEstoque >= ?";
	
	
	@Override
	public Collection<PigmentoRGB> pesquisarPigmentoRGBDisponiveis(double qtdSolicitada){
		List<PigmentoRGB> listaDePigmentosRGBDisponiveis = new ArrayList<PigmentoRGB>();
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(EstoqueSQLDAO.SELECT_PIGMENTO_RGB);
			stmt.setDouble(1, qtdSolicitada);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				PigmentoRGB pigRGB = new PigmentoRGB();
				pigRGB.setId((rSet.getString("idPigmento")));
				pigRGB.setNome(rSet.getString("nome"));
				pigRGB.setPreco(rSet.getDouble("preco"));
				pigRGB.setQtdNoEstoque(rSet.getDouble("qtdNoEstoque"));
				pigRGB.setRed(rSet.getInt("red"));
				pigRGB.setGreen(rSet.getInt("green"));
				pigRGB.setBlue(rSet.getInt("blue"));
				listaDePigmentosRGBDisponiveis.add(pigRGB);
			}		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDePigmentosRGBDisponiveis;
}


	@Override
	public void debitar(String corEscolhida) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pigmento getInfoPigmento(String idDoPigmento) {
		//SELECT PEGANDO O PIGMENTO ESCOLHIDO A PARTIR DO ID PASSADO NA CLASSE VENDEDOR
		return null;
	}


	@Override
	public Collection<PigmentoCMYK> pesquisarPigmentoCMYKDisponiveis(double qtdSolicitada)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		List<PigmentoCMYK> listaDePigmentosCMYKDisponiveis = new ArrayList<PigmentoCMYK>();
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(EstoqueSQLDAO.SELECT_PIGMENTO_CMYK);
			stmt.setDouble(1, qtdSolicitada);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				PigmentoCMYK pigCMYK = new PigmentoCMYK();
				pigCMYK.setId((rSet.getString("idPigmento")));
				pigCMYK.setNome(rSet.getString("nome"));
				pigCMYK.setPreco(rSet.getDouble("preco"));
				pigCMYK.setQtdNoEstoque(rSet.getDouble("qtdNoEstoque"));
				pigCMYK.setCyan(rSet.getInt("cyan"));
				pigCMYK.setMagenta(rSet.getInt("magenta"));
				pigCMYK.setYellow(rSet.getInt("yellow"));
				pigCMYK.setKeyBlack(rSet.getInt("keyblack"));
				listaDePigmentosCMYKDisponiveis.add(pigCMYK);
			}		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return listaDePigmentosCMYKDisponiveis;
	}
	
	
	
	 
}
