public class Estilo {
  private final static String INICIO = "\u001b[";
  private final static String FINAL = "\u001b[m";

  public static String ini() {
    return INICIO;
  }

  public static String fim() {
    return FINAL;
  }

  public static String bold() {
    return "1m";
  }

  public static String intalic() {
    return "3m";
  }

  public static String subl() {
    return "4m";
  }

  public static String pisc() {
    return "5m";
  }

  public static String invert() {
    return "7m";
  }

  public static String risc() {
    return "9m";
  }

  public static String textBlack() {
    return ini() + "30m";
  }

  public static String bgBlack() {
    return ini() + "40m";
  }

  public static String textRed() {
    return ini() + "31m";
  }

  public static String bgRed() {
    return ini() + "41m";
  }

  public static String textGreen() {
    return ini() + "32m";
  }

  public static String bgGreen() {
    return ini() + "42m";
  }

  public static String textYel() {
    return ini() + "33m";
  }

  public static String bgYel() {
    return ini() + "43m";
  }

  public static String textBlue() {
    return ini() + "34m";
  }

  public static String bgBlue() {
    return ini() + "44m";
  }

  public static String textMag() {
    return ini() + "35m";
  }

  public static String bgMag() {
    return ini() + "45m";
  }

  public static String textCian() {
    return ini() + "36m";
  }

  public static String bgCian() {
    return ini() + "46m";
  }

  public static String textWhite() {
    return ini() + "37m";
  }

  public static String bgWhite() {
    return ini() + "47m";
  }
}