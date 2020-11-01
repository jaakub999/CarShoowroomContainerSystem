public enum ItemCondition
{
    NEW
            {
                @Override
                public String toString() {return "Nowy";}
            },
    USED
            {
                @Override
                public String toString() {return "Używany";}
            },
    DAMAGED
            {
                @Override
                public String toString() {return "Powypadkowy";}
            }
}