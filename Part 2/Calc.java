public class Calc {

	public static Fraction parseE(List l) {

		Fraction res = parseM(l);

		// System.out.println(l);

		while (!l.isEmpty() && (l.head().equals("+") || l.head().equals("-"))) {

			if (l.head().equals("+")) {
				l.tail();

				// System.out.println(l);

				res = res.add(parseE(l));

			} else {

				l.tail();

				// System.out.println(l);

				res = res.subtract(parseE(l));

			}

		}

		return res;

	}

	public static Fraction parseM(List l){

		Fraction res = parseT(l);

		while (!l.isEmpty() && (l.head().equals("*") || l.head().equals("/"))) {

			if (l.head().equals("*")) {

				l.tail();

				res = res.multiply(parseM(l));

			} else {

				l.tail();

				res = res.divide(parseM(l));

			}

		}

		return res;
	}

	public static Fraction parseT(List l) {

		Fraction res;

		if (l.head().equals("(")) {

			l.tail();

			res = parseE(l);

			// Remove last ")"
			l.tail();

		} else {


			res = new Fraction(Integer.parseInt(l.head()));
			l.tail();

		}

		return res;
	}

	public static void main(String[] args) {

		String input = "2 * 5";

		List l = new List(input.split(" "));

		try {

			System.out.println(parseE(l));

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}