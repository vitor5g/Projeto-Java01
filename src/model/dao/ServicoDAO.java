package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Servico;

public class ServicoDAO {

    public static Servico cadastrar(Servico s) throws ParseException {
        Date data = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico(nome_empresa,nome_responsavel,telefone,celular,rua,numero,bairro,referencia,complemento,data_servico,valor,descricao,data_vencimento)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, s.getNome_empresa());
            stmt.setString(2, s.getNome_responsavel());
            stmt.setString(3, s.getTelefone());
            stmt.setString(4, s.getCelular());
            stmt.setString(5, s.getRua());
            stmt.setString(6, s.getNumero());
            stmt.setString(7, s.getBairro());
            stmt.setString(8, s.getReferencia());
            stmt.setString(9, s.getComplemento());
            stmt.setString(10, s.formataDataRetornaBDServico(s.getData_servico()));
            stmt.setString(11, s.getValor());
            stmt.setString(12, s.getDescricao());
            stmt.setString(13, s.formataDataRetornaBDVencimento(s.getData_vencimento()));
            if (stmt.executeUpdate() > 0) {
                rs = stmt.getGeneratedKeys();
//                while (rs.next()) {
//                    s.setId(rs.getInt(1));
//                    stmt = con.prepareStatement("UPDATE servico set data_vencimento = ?  WHERE id = ?");
//                    stmt.setString(1, "date(servico.data_servico, '+" + s.getData_vencimento() + " day')");
//                    stmt.setInt(2, s.getId());
//                    stmt.executeUpdate();
//                }
                s.setMensagem("Cadastro realizado com sucesso");
                JOptionPane.showMessageDialog(null, "<html><font color=#0E6B19>" + s.getMensagem() + "</font></html>");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return s;
    }

    public static List<Servico> read() throws ParseException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();

                servico.setId(rs.getInt("id"));
                servico.setNome_empresa(rs.getString("nome_empresa"));
                servico.setNome_responsavel(rs.getString("nome_responsavel"));
                servico.setTelefone(rs.getString("telefone"));
                servico.setCelular(rs.getString("celular"));
                servico.setRua(rs.getString("rua"));
                servico.setNumero(rs.getString("numero"));
                servico.setBairro(rs.getString("bairro"));
                servico.setReferencia(rs.getString("referencia"));
                servico.setComplemento(rs.getString("complemento"));
                servico.setData_servico(servico.formataDataExibeServico(rs.getString("data_servico")));
                servico.setValor(rs.getString("valor"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setData_vencimento(servico.formataDataExibeVencimento(rs.getString("data_vencimento")));

                servicos.add(servico);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;
    }

    public static List<Servico> readId(int id) throws ParseException {
        Servico servico = new Servico();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico WHERE id = ?");
            stmt.setInt(1, Servico.getId_pesquisa());
            rs = stmt.executeQuery();

            while (rs.next()) {
//                Servico servico = new Servico();

                servico.setId(rs.getInt("id"));
                servico.setNome_empresa(rs.getString("nome_empresa"));
                servico.setNome_responsavel(rs.getString("nome_responsavel"));
                servico.setTelefone(rs.getString("telefone"));
                servico.setCelular(rs.getString("celular"));
                servico.setRua(rs.getString("rua"));
                servico.setNumero(rs.getString("numero"));
                servico.setBairro(rs.getString("bairro"));
                servico.setReferencia(rs.getString("referencia"));
                servico.setComplemento(rs.getString("complemento"));
                servico.setData_servico(servico.formataDataExibeServico(rs.getString("data_servico")));
                servico.setData_vencimento(servico.formataDataExibeVencimento(rs.getString("data_vencimento")));
                servico.setValor(rs.getString("valor"));
                servico.setDescricao(rs.getString("descricao"));

                servicos.add(servico);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;
    }

    public static void delete(Servico s) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM servico WHERE id = ?");
            stmt.setInt(1, s.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public static void update(Servico s) throws ParseException {
        ResultSet rs = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE servico SET nome_empresa = ?,nome_responsavel = ?,telefone = ?,celular = ?, rua = ?,numero = ?, bairro = ?, referencia = ?, complemento = ?, data_servico = ?, valor = ?, descricao = ?, data_vencimento = ? WHERE id = ?");
            stmt.setString(1, s.getNome_empresa());
            stmt.setString(2, s.getNome_responsavel());
            stmt.setString(3, s.getTelefone());
            stmt.setString(4, s.getCelular());
            stmt.setString(5, s.getRua());
            stmt.setString(6, s.getNumero());
            stmt.setString(7, s.getBairro());
            stmt.setString(8, s.getReferencia());
            stmt.setString(9, s.getComplemento());
            stmt.setString(10, (s.formataDataRetornaBDServico(s.getData_servico())));
            stmt.setString(11, s.getValor());
            stmt.setString(12, s.getDescricao());
            stmt.setString(13, (s.formataDataRetornaBDVencimento(s.getData_vencimento())));
            stmt.setInt(14, s.getId());

            if (stmt.executeUpdate() > 0) {

////                    s.setId(rs.getInt(1));
//                    System.out.println(s.getId());
//                stmt = con.prepareStatement("UPDATE servico set data_vencimento = date(servico.data_servico, '+90 day') WHERE id = ?");
//                stmt.setInt(1, s.getId());
//                stmt.executeUpdate();
                s.setMensagem("Servico atualizado com sucesso");
                JOptionPane.showMessageDialog(null, "<html><font color=#0E6B19>" + s.getMensagem() + "</font></html>");
            }
//            System.out.println(s.getId());

//                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static List<Servico> readBusca(String opcao, String busca) throws ParseException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico WHERE " + opcao + " LIKE ? ");
//            stmt.setString(1, opcao);
            stmt.setString(1, "%" + busca + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Servico servico = new Servico();

                servico.setId(rs.getInt("id"));
                servico.setNome_empresa(rs.getString("nome_empresa"));
                servico.setNome_responsavel(rs.getString("nome_responsavel"));
                servico.setTelefone(rs.getString("telefone"));
                servico.setCelular(rs.getString("celular"));
                servico.setRua(rs.getString("rua"));
                servico.setNumero(rs.getString("numero"));
                servico.setBairro(rs.getString("bairro"));
                servico.setReferencia(rs.getString("referencia"));
                servico.setComplemento(rs.getString("complemento"));
                servico.setData_servico(servico.formataDataExibeServico(rs.getString("data_servico")));
                servico.setValor(rs.getString("valor"));
                servico.setDescricao(rs.getString("descricao"));

                servicos.add(servico);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;
    }

    public static List<Servico> readBuscaDatas() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();
        try {

            String dataAtual = df.format(data);
//        System.out.println(df.format(data.getTime()));
            String dataGarantia;
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 5);
//        System.out.println(df.format(cal.getTime()));

            stmt = con.prepareStatement("SELECT julianday ('" + df.format(cal.getTime()) + "') - julianday ('" + df.format(data.getTime()) + "') AS dias");
//            System.out.println(df.format(data.getTime()));
            /*Crio a variavel para salvar os 5 dias*/
            int faltaDias = 0;
            rs = stmt.executeQuery();
//            stmt.close();

//            System.out.println(df.format(cal.getTime()));
//            System.out.println(df.format(data.getTime()));
            while (rs.next()) {
                faltaDias = (rs.getInt("dias"));

            }

            if (faltaDias <= 5) {

                df = new SimpleDateFormat("yyyy-MM-dd");
                stmt = con.prepareStatement("SELECT * FROM servico WHERE servico.data_vencimento >= '" + df.format(data.getTime()) + "' AND servico.data_vencimento <= '" + df.format(cal.getTime()) + "'");

                rs = stmt.executeQuery();
                while (rs.next()) {
                    Servico servico = new Servico();
                    servico.setId(rs.getInt("id"));
                    servico.setData_vencimento(servico.formataDataExibeVencimento(rs.getString("data_vencimento")));
                    servico.setData_servico(servico.formataDataExibeServico(rs.getString("data_servico")));

                    servicos.add(servico);
                }

            } else {
                System.out.println("diferente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return servicos;
    }

    public static int totalServicos() {
//        Servico s = new Servico();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stmt = con.prepareStatement("SELECT count(*) as contador from servico");
            rs = stmt.executeQuery();
            rs.next();

            count = (rs.getInt(1));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return count;
    }

}
