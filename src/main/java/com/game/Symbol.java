package com.game;

import java.util.Optional;

public enum Symbol {
    ROCK {
        Optional<Symbol[]> getBeatableSymbols() {
            return Optional.of(new Symbol[]{Symbol.SCISSORS});
        }

        public char getKey() {
            return 'r';
        }
    },
    PAPER {
        Optional<Symbol[]> getBeatableSymbols() {
            return Optional.of(new Symbol[]{Symbol.ROCK});
        }

        public char getKey() {
            return 'p';
        }

    },
    SCISSORS {
        protected Optional<Symbol[]> getBeatableSymbols() {
            return Optional.of(new Symbol[]{Symbol.PAPER});
        }

        public char getKey() {
            return 's';
        }
    };

    abstract Optional<Symbol[]> getBeatableSymbols();

    abstract char getKey();

    public boolean beats(Symbol symbol) {
        if (getBeatableSymbols().isPresent()) {
            for (Symbol beatableSymbol : getBeatableSymbols().get()) {
                if (beatableSymbol.equals(symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Optional<Symbol> fromKey(char key) {
        for (Symbol symbol : Symbol.values()) {
            if (symbol.getKey() == key) {
                return Optional.of(symbol);
            }
        }

        return Optional.empty();
    }
}
