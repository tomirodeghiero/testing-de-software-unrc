package assignment7_exercises.ncl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

class NodeCachingLinkedListPropertiesTest {

    @Property(tries = 200)
    void luegoDeRemoverUnElementoSeIncrementaEnUnoElTamanoDeCache(
        @ForAll("escenariosRemocion") EscenarioRemocion escenario
    ) {
        NodeCachingLinkedList ncl = escenario.lista;

        assertTrue(ncl.repOK());
        int cacheAntes = ncl.getCacheSize();

        Integer removido = ncl.removeIndex(escenario.index);

        assertNotNull(removido);
        assertEquals(cacheAntes + 1, ncl.getCacheSize());
    }

    @Property(tries = 200)
    void siLaCacheNoEstaVaciaAgregarMantieneConstanteLaSumaDeNodos(
        @ForAll("escenariosAgregarConCacheNoVacia") EscenarioAgregarConCache escenario
    ) {
        NodeCachingLinkedList ncl = escenario.lista;

        assertTrue(ncl.repOK());
        assertTrue(ncl.getCacheSize() > 0);
        int sumaAntes = ncl.getSize() + ncl.getCacheSize();

        ncl.addFirst(escenario.nuevoValor);

        int sumaDespues = ncl.getSize() + ncl.getCacheSize();
        assertEquals(sumaAntes, sumaDespues);
    }

    @Property(tries = 200)
    void eliminarUnElementoMantieneElInvarianteDeRepresentacion(
        @ForAll("escenariosRemocion") EscenarioRemocion escenario
    ) {
        NodeCachingLinkedList ncl = escenario.lista;

        assertTrue(ncl.repOK());

        ncl.removeIndex(escenario.index);

        assertTrue(ncl.repOK());
    }

    @Provide
    Arbitrary<EscenarioRemocion> escenariosRemocion() {
        return Arbitraries.integers().between(1, 15).flatMap(size ->
            Arbitraries.integers().between(-1000, 1000).list().ofSize(size).flatMap(valores ->
                Arbitraries.integers().between(0, size - 1).map(index ->
                    new EscenarioRemocion(crearLista(valores), index)
                )
            )
        );
    }

    @Provide
    Arbitrary<EscenarioAgregarConCache> escenariosAgregarConCacheNoVacia() {
        return Arbitraries.integers().between(1, 15).flatMap(size ->
            Arbitraries.integers().between(-1000, 1000).list().ofSize(size).flatMap(valores ->
                Arbitraries.integers().between(0, size - 1).flatMap(indexARemover ->
                    Arbitraries.integers().between(-1000, 1000).map(nuevoValor -> {
                        NodeCachingLinkedList ncl = crearLista(valores);
                        ncl.removeIndex(indexARemover);
                        return new EscenarioAgregarConCache(ncl, nuevoValor);
                    })
                )
            )
        );
    }

    private static NodeCachingLinkedList crearLista(List<Integer> valores) {
        NodeCachingLinkedList ncl = new NodeCachingLinkedList();
        for (Integer valor : valores) {
            ncl.addFirst(valor);
        }
        return ncl;
    }

    private static class EscenarioRemocion {
        private final NodeCachingLinkedList lista;
        private final int index;

        private EscenarioRemocion(NodeCachingLinkedList lista, int index) {
            this.lista = lista;
            this.index = index;
        }
    }

    private static class EscenarioAgregarConCache {
        private final NodeCachingLinkedList lista;
        private final int nuevoValor;

        private EscenarioAgregarConCache(NodeCachingLinkedList lista, int nuevoValor) {
            this.lista = lista;
            this.nuevoValor = nuevoValor;
        }
    }
}
