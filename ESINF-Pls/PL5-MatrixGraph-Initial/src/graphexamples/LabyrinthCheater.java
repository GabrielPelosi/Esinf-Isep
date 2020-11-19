
package graphexamples;

import graph.AdjacencyMatrixGraph;
import graph.GraphAlgorithms;

import java.util.LinkedList;
import java.util.Objects;

/**
 * A class to represent a labyrinth map with rooms, doors and exits
 * Methods discover the nearest exit and the path to it
 * Stores a graph of private Room vertex and Door edges
 *
 * @author DEI-ESINF
 * 
 */
public class LabyrinthCheater {

    private class Room{
        private String name;
        private boolean hasExit;

        public Room(String name, boolean hasExit){
            this.name=name;
            this.hasExit=hasExit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return name.equals(room.name);
        }
    }

    private class Door{
    }

    AdjacencyMatrixGraph<Room, Door> map;

    public LabyrinthCheater(){
        map = new AdjacencyMatrixGraph<Room, Door>();
    }

    /**
     * Inserts a new room in the map
     * @param city
     * @return false if city exists in the map
     */
    public boolean insertRoom(String name, boolean hasExit){
        return map.insertVertex(new Room(name,hasExit));
    }

    /**
     * Inserts a new door in the map
     * fails if room does not exist or door already exists
     * @param from room
     * @param to room
     * @return false if a room does not exist or door already exists between rooms
     */
    public boolean insertDoor(String from, String to){
        return map.insertEdge(new Room(from,true),new Room(to,true),new Door());
    }

    /**
     * Returns a list of rooms which are reachable from one room
     * @param room 
     * @return list of room names or null if room does not exist
     */
    public Iterable<String> roomsInReach(String room, boolean hasExit){
        if(!map.checkVertex(new Room(room,hasExit))) return null;
        //nao funciona pois DFS não implementando, mas o codigo está correto.
        LinkedList<Room> rooms = GraphAlgorithms.DFS(map,new Room(room,false));

        LinkedList<String> names = new LinkedList<>();
        for (Room r : rooms){
            names.add(r.name);
        }
        return names;
    }

    /**
     * Returns the nearest room with an exit
     * @param room from room
     * @return room name or null if from room does not exist or there is no reachable exit
     */
    public String nearestExit(String room){
        if (!map.checkVertex(new Room(room,false))) return null;

        LinkedList<Room> rooms = GraphAlgorithms.BFS(map,new Room(room,false));

        for (Room r: rooms){
            if (r.hasExit) return r.name;
        }
        return null;
    }

    
}
