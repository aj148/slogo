package controller;

import java.util.Set;

import commands.Command;

import parser.Parser;

/**
 * Superclass to contain the Parser and a set of executable commands.
 * This information is used by Controller subclasses.
 * 
 * @author Team 14
 */
public abstract class MasterController {
    
    protected static Parser myParser;
    protected static Set<Command> myCommandSet;
}