/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.CadastroServico;

/**
 *
 * @author Vitor Lopes
 */
public class Servico {

    private int id;
    private static int id_pesquisa;
    private String nome_empresa = "";
    private String nome_responsavel = "";
    private String telefone = "";
    private String celular = "";
    private String rua = "";
    private String numero = "";
    private String bairro = "";
    private String referencia = "";
    private String complemento = "";
    private String data_servico = "";
    private String valor = "";
    private String descricao = "";
    private String mensagem = "";
    private String data_vencimento = "";
    private int total_servicos = 0;

    public int getTotal_servicos() {
        return total_servicos;
    }

    public void setTotal_servicos(int total_servicos) {
        this.total_servicos = total_servicos;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public static int getId_pesquisa() {
        return id_pesquisa;
    }

    public static void setId_pesquisa(int id_pesquisa) {
        Servico.id_pesquisa = id_pesquisa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    //aqui eu converto a data pra ano/mes/dia
    public String formataDataRetornaBDServico(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d = df.parse(data);
        df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(d);
        return data_servico = s;
    }

    //aqui eu converto para dia/mes/ano
    public String formataDataExibeServico(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(data);
        df = new SimpleDateFormat("dd/MM/yyyy");
        String s = df.format(d);
        return this.data_servico = s;
    }

    //aqui eu converto a data pra ano/mes/dia
    public String formataDataRetornaBDVencimento(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d = df.parse(data);
        df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(d);
        return data_vencimento = s;
    }

    //aqui eu converto para dia/mes/ano
    public String formataDataExibeVencimento(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(data);
        df = new SimpleDateFormat("dd/MM/yyyy");
        String s = df.format(d);
        return this.data_vencimento = s;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getData_servico() {
        return data_servico;
    }

    public void setData_servico(String data_servico) {
        this.data_servico = data_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + "\n"
                + "nome_empresa=" + nome_empresa + "\n"
                + "\n nome_responsavel=" + nome_responsavel + "\n"
                + "telefone=" + telefone + "\n"
                + "celular=" + celular + "\n"
                + "rua=" + rua + "\n"
                + " numero=" + numero + "\n"
                + "bairro=" + bairro + "\n"
                + "referencia=" + referencia + "\n"
                + "complemento=" + complemento + "\n"
                + "data_servico=" + data_servico + "\n"
                + "valor=" + valor + "\n"
                + "descricao=" + descricao + "\n"
                + "mensagem=" + mensagem + "\n"
                + "data_vencimento=" + data_vencimento + "\n"
                + "total_servicos=" + total_servicos + '}';
    }
    
    

}
