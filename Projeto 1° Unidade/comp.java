/* Generated By:JavaCC: Do not edit this line. comp.java */
class comp implements compConstants {
        public static void main( String[] args )throws ParseException
        {
                try
                {
                        comp analizador = new comp( System.in ) ;
                        analizador.Program() ;
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("Analizador: erro durante o processo de an\u00c3\u00a1lise.");
                }
        }

  static final public void Program() throws ParseException {
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(SIMBOLOS);
    block();
  }

  static final public void block() throws ParseException {
    variableDeclarationPart();
    statementPart();
  }

  static final public void variableDeclarationPart() throws ParseException {
    jj_consume_token(SIMBOLOS_ESPECIAIS);
    variableDeclaration();
    jj_consume_token(SIMBOLOS);
    jj_consume_token(LCHAVE);
    variableDeclaration();
    jj_consume_token(SIMBOLOS);
    jj_consume_token(RCHAVE);
  }

  static final public void variableDeclaration() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(LCHAVE);
    jj_consume_token(SIMBOLOS);
    jj_consume_token(IDENTIFICADORES);
    jj_consume_token(RCHAVE);
    jj_consume_token(SIMBOLOS);
    type();
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIPOS:
      simpleType();
      break;
    case SIMBOLOS_ESPECIAIS:
      arrayType();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void arrayType() throws ParseException {
    jj_consume_token(SIMBOLOS_ESPECIAIS);
    jj_consume_token(LCOLCHETE);
    indexRange();
    jj_consume_token(RCOLCHETE);
    jj_consume_token(SIMBOLOS_ESPECIAIS);
    jj_consume_token(SIMBOLOS_ESPECIAIS);
  }

  static final public void indexRange() throws ParseException {
    jj_consume_token(NUMEROS);
  }

  static final public void simpleType() throws ParseException {
    jj_consume_token(TIPOS);
  }

  static final public void typeIdentifier() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
  }

  static final public void statementPart() throws ParseException {
    compoundStatement();
  }

  static final public void compoundStatement() throws ParseException {
    jj_consume_token(INSTRUCOES);
    statement();
    jj_consume_token(LCHAVE);
    jj_consume_token(SIMBOLOS);
    statement();
    jj_consume_token(RCHAVE);
    jj_consume_token(INSTRUCOES);
  }

  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMANDOS:
    case IDENTIFICADORES:
      simpleStatement();
      break;
    case INSTRUCOES:
      structuredStatement();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void simpleStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADORES:
      assignment();
      break;
    case COMANDOS:
      readStatement();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void structuredStatement() throws ParseException {
    compoundStatement();
  }

  static final public void ifStatement() throws ParseException {
    jj_consume_token(INSTRUCOES);
    expression();
    jj_consume_token(INSTRUCAO_THEN);
    statement();
  }

  static final public void whileStatement() throws ParseException {
    jj_consume_token(INSTRUCOES);
    expression();
    jj_consume_token(INSTRUCAO_DO);
    statement();
  }

  static final public void readStatement() throws ParseException {
    jj_consume_token(COMANDOS);
    jj_consume_token(LPAREN);
    variable();
    jj_consume_token(LCHAVE);
    jj_consume_token(SIMBOLOS);
    variable();
    jj_consume_token(RCHAVE);
    jj_consume_token(RPAREN);
  }

  static final public void writeStatement() throws ParseException {
    jj_consume_token(COMANDOS);
    jj_consume_token(LPAREN);
    variable();
    jj_consume_token(RCHAVE);
    jj_consume_token(SIMBOLOS);
    variable();
    jj_consume_token(RCHAVE);
    jj_consume_token(RPAREN);
  }

  static final public void assignment() throws ParseException {
    variable();
    jj_consume_token(OPERADORES);
    expression();
  }

  static final public void variable() throws ParseException {
    entireVariable();
  }

  static final public void entireVariable() throws ParseException {
    variableIdentifier();
  }

  static final public void variableIdentifier() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
  }

  static final public void indexedVariable() throws ParseException {
    arrayVariable();
    jj_consume_token(LCOLCHETE);
    expression();
    jj_consume_token(RCOLCHETE);
  }

  static final public void arrayVariable() throws ParseException {
    entireVariable();
  }

  static final public void expression() throws ParseException {
    simpleExpression();
  }

  static final public void relationalOperator() throws ParseException {
    jj_consume_token(OPERADORES);
  }

  static final public void simpleExpression() throws ParseException {
    sing();
    term();
    jj_consume_token(LCHAVE);
    addingOperator();
    term();
    jj_consume_token(RCHAVE);
  }

  static final public void sing() throws ParseException {
    jj_consume_token(OPERADORES);
  }

  static final public void addingOperator() throws ParseException {
    jj_consume_token(OPERADORES);
  }

  static final public void term() throws ParseException {
    factor();
    jj_consume_token(LCHAVE);
    multiplyingOperator();
    factor();
    jj_consume_token(RCHAVE);
  }

  static final public void factor() throws ParseException {
    variable();
  }

  static final public void multiplyingOperator() throws ParseException {
    jj_consume_token(OPERADORES);
  }

  static final public void constant() throws ParseException {
    integerConstante();
  }

  static final public void integerConstante() throws ParseException {
    jj_consume_token(IDENTIFICADORES);
  }

  static final public void characterConstant() throws ParseException {
    lettetOrDigit();
  }

  static final public void lettetOrDigit() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADORES:
      jj_consume_token(IDENTIFICADORES);
      break;
    case NUMEROS:
      jj_consume_token(NUMEROS);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public compTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2400,0x4220,0x4200,0x5000,};
   }

  /** Constructor with InputStream. */
  public comp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public comp(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public comp(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public comp(compTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(compTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[25];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 25; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
