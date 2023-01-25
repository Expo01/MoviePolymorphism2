public class NextMain {
    public static void main(String[] args) {

        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws"); //without the (Adventure) instance cast, the compiler
        //can't tell that Movie.getMovie will return an Adventure, since it won't run any code to figure out the correct type.
        // if I keep the cast but change the type to comedy, it still compile and not get an error until run-time which is bad
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
//        comedy.watchComedy(); this won't call the 'watchComedy' method as anticipated because compiler only sees
        // 'comedy' as an Object and can't access methods of Comedy class
        Comedy comedyMovie = (Comedy) comedy; // need to create and cast a reference variable to access
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        Object unknownObject = Movie.getMovie("S", "Star Wars");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        }
    }
}
