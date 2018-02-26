package Beans;
/*
 @author Tiago e Paulo 29/07/2016 15:44
 */
public class BeanRetorno {
    
    //Variaveis Do Registro Header
    public int      HCodigoDoRegistro                               = 0;    //9(01)
    public int      HCodigoDeOperacao                               = 0;    //9(01)
    public String   HIdentificacaoPorExtenso                        = "";   //X(07)
    public int      HCodigoDoServico                                = 0;    //9(02)
    public String   HIdentificacaoDoServico                         = "";   //X(15)
    public int      HNumeroDaAgencia                                = 0;    //9(04)
    public String   HComplementoDeRegistro1                         = "";   //9(02)
    public String   HNumeroDaContaCorrente                          = "";   //9(05)
    public int      HDigitoAutoConferencia                          = 0;    //9(01)
    public String   HComplementoDeRegistro2                         = "";   //X(08)
    public String   HNomeDaEmpresa                                  = "";   //X(30)
    public int      HCodigoDoBanco                                  = 0;    //9(03)
    public String   HNomeDoBanco                                    = "";   //X(15)
    public String   HDataDeGeracao                                  = "";   //9(06)
        public String HDiaDeGeracao                                 = "";
        public String HMesDeGeracao                                 = "";
        public String HAnoDeGeracao                                 = "";
    public int      HUnidadeDaDensidade                             = 0;    //9(05)
    public String   HDensidadeDeGravacao                            = "";   //X(03)
    public int      HNumeroSequencialDoArquivoRetorno               = 0;    //9(05)
    public String   HDataDeCreditoDosLancamentos                    = "";   //9(06)
    public String   HComplementoDeRegistro3                         = "";   //X(275)
    public int      HNumeroSequencialDoRegistroNoArquivo            = 0;    //9(06)
    
    //Variaveis DoRegistro Detalhe
    public int      DCodigoDoRegistro                               = 0;    //9(01)
    public String   DCodigoDeInscricao                              = "";   //9(02)
    public String   DNumeroDeInscricaoDaEmpresa                     = "";   //9(14)
    public int      DNumeroDaAgencia                                = 0;    //9(04)
    public String   DComplementoDeRegistro1                         = "";   //9(02)
    public String   DNumeroDaContaCorrente                          = "";   //9(05)
    public int      DDigitoAutoConferencia                          = 0;    //9(01)
    public String   DComplementoDeRegistro2                         = "";   //X(08)
    public String   DIdentificacaoDoTituloNaEmpresa                 = "";   //X(25)
    public String   DIdentificacaoDoTituloNoBanco1                  = "";   //9(08)
    public String   DComplementoDeRegistro3                         = "";   //X(12)
    public String   DNumeroDaCarteira                               = "";   //9(03)
    public String   DIdentificacaoDoTituloNoBanco2                  = "";   //9(08)
    public int      DDacDoNossoNumero                               = 0;    //9(01)
    public String   DComplementoDeRegistro4                         = "";   //X(13)
    public String   DCodigoDaCarteira                               = "";   //X(01)
    public String   DIdentificacaoDaOcorrencia                      = "";   //9(02)
    public String   DDataDaOocorrenciaNoBanco                       = "";   //9(06)
    public String   DNumeroDoDocumentoDeCobranca                    = "";   //X(10)
    public int      DConfirmacaoDoNumeroDoTituloNoBanco             = 0;    //9(08)
    public String   DComplementoDeRegistro5                         = "";   //X(12)
    public String   DDataDeVencimentoDoTitulo                       = "";   //9(06)
        public String DDiaDeVencimentoDoTitulo                      = "";
        public String DMesDeVencimentoDoTitulo                      = "";
        public String DAnoDeVencimentoDoTitulo                      = "";
    public double   DValorNominalDoTitulo                           = 0;    //9(11)V9(2)
    public int      DNumeroDoBancoCamaraCompensacao                 = 0;    //9(03)
    public int      DAgenciaCobradoraLiquidacaoOuBaixa              = 0;    //9(04)
    public int      DDacDaAgenciaCobradora                          = 0;    //9(01)
    public String   DEspecieDoTitulo                                = "";   //9(02)
    public double   DValorDaDespesaDeCobranca                       = 0;    //9(11)V9(2)
    public String   DComplementoDeRegistro6                         = "";   //X(26)
    public double   DValorDoIOFRecolhidoParaNotasSeguro             = 0;    //9(11)V9(2)
    public double   DValorDoAbatimentoASerConcedido                 = 0;    //9(11)V9(2)
    public double   DValorDoDescontoConcedido                       = 0;    //9(11)V9(2)
    public double   DValorLancadoEmContaCorrente                    = 0;    //9(11)V9(2)
    public double   DValorDeMoraEMulta                              = 0;    //9(11)V9(2)
    public double   DValorDeOutrosCreditos                          = 0;    //9(11)V9(2)
    public String   DIndicadorDeBoletoDDA                           = "";   //X(01)
    public String   DComplementoDeRegistro7                         = "";   //X(02)
    public String   DDataDeCreditoDestaLiquidacao                   = "";   //X(06)
    public int      DCodigoDaInstrucaoCancelada                     = 0;    //9(04)
    public String   DComplementoDeRegistro8                         = "";   //X(06)
    public String   DComplementoDeRegistro9                         = "";   //9(13)
    public String   DNomeDoPagador                                  = "";   //X(30)
    public String   DComplementoDeRegistro10                        = "";   //X(23)
    public String   DRegRejOuAleDoPagOuRegDeMenInf                  = "";   //X(08)
    public String   DComplementoDeRegistro11                        = "";   //X(07)
    public String   DMeioPeloQualOTituloFoiLiquidado                = "";   //X(02)
    public int      DNumeroSequencialDoRegistroNoArquivo            = 0;    //9(06)
    
    //Variavies Do Registro Trailer
    public int      TCodigoDoRegistro                               = 0;    //9(01)
    public int      TCodigoDoArquivoDeRetorno                       = 0;    //9(01)
    public int      TCodigoDoServico                                = 0;    //9(02)
    public int      TCodigoDoBancoNaCompensacao                     = 0;    //9(03)
    public String   TComplementoDeRegistro1                         = "";   //X(10)
    public int      TQtdDeTitulosEmCobrancaSimples                  = 0;    //9(08)
    public double   TValorTotalDosTitulosEmCobrancaSimples          = 0;    //9(12)V9(2)
    public String   TReferenciaDoAvisoBancario1                     = "";   //X(08)
    public String   TComplementoDeRegistro2                         = "";   //X(10)
    public int      TQtdDeTitulosEmCobrancaVinculada                = 0;    //9(08)
    public double   TValorTotalDosTitulosEmCobrancaVinculada        = 0;    //9(12)V9(2)
    public String   TReferenciaDoAvisoBancario2                     = "";   //X(08)
    public String   TComplementoDeRegistro3                         = "";   //X(90)
    public int      TQtdDeTitulosEmCobrancaDiretaEscritural         = 0;    //9(08)
    public double   TValorTotalDosTitulosEmCobrancaDiretaEscritural = 0;    //9(12)V9(2)
    public String   TReferenciaDoAvisoBancario3                     = "";   //X(08)
    public int      TNumeroSequencialDoArquivoDeRetorno             = 0;    //9(05)
    public int      TQtdDeRegistrosDeTransacao                      = 0;    //9(08)
    public double   ValorTotalDosTitulosInformadosNoArquivo         = 0;    //9(12)V9(2)
    public String   TComplementoDeRegistro4                         = "";   //X(160)
    public int      TNumeroSequencialDoRegistroNoArquivo            = 0;    //9(06)
    
}