package com.cleantestautomation.junit5intro;

/**
 * Specifies different programming paradigms.
 */
public enum ProgrammingParadigm {

    FUNCTIONAL,
    OBJECT_ORIENTED,
    PROCEDURAL;

    /**
     * Returns the paradigm of the given programming language.
     * @param source    The programming language
     */
    public static ProgrammingParadigm fromProgrammingLanguage(ProgrammingLanguage source) {
        return switch(source) {
            case C -> ProgrammingParadigm.PROCEDURAL;
            case CLOSURE -> ProgrammingParadigm.FUNCTIONAL;
            case SMALLTALK -> ProgrammingParadigm.OBJECT_ORIENTED;
        };
    }
}
