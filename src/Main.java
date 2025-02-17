public class Main {
    public static void main(String[] args) {
        List<DeskoveHry> games = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("deskovky.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nazev = parts[0].trim();
                    boolean zakoupeno = parts[1].trim().equalsIgnoreCase("ano");
                    int nejoblibenejsi = Integer.parseInt(parts[2].trim());
                    games.add(new DeskoveHry(nazev, zakoupeno, nejoblibenejsi));
                }
            }
        } catch (IOException e) {

        }
    GUI gui = new GUI(games);
    gui.setVisible(true);
    }
}