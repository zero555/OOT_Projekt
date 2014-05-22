	public enum Ecke {

		A(0, 0, 1, 1), B(0, 15, 1, -1), C(15, 0, -1, 1), D(15, 15, -1, -1);

		private final int indexSpalte;
		private final int indexZeile;
		private final int nDirZeile;
		private final int nDirSpalte;

		private Ecke(int indexZeile, int indexSpalte, int nDirZeile,
				int nDirSpalte) {
			this.indexZeile = indexZeile;
			this.indexSpalte = indexSpalte;
			this.nDirZeile = nDirZeile;
			this.nDirSpalte = nDirSpalte;

		}

		public int getnDirSpalte() {
			return nDirSpalte;
		}

		public int getnDirZeile() {
			return nDirZeile;
		}

		public int getIndexSpalte() {
			return indexSpalte;
		}

		public int getIndexZeile() {
			return indexZeile;
		}

	}
