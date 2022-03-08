#!/usr/bin/env python

import common
from numpy.random import randint
from dataclasses import dataclass


@dataclass
class Config(common.Config):
    max_value: int

    def __init__(self):
        super().__init__()
        self.max_value = (1 << self.length) - 1

    def main(self):
        population = []

        # Generate a population of individuals
        for i in range(0, self.population_size):
            population.append(randint(0, self.max_value+1))

        self.genetic_algorithm(population, self.fitness, self.make_mutation)
        self.plot('Deceptive Landscape')

    def fitness(self, individual):
        # If the individual has no 1's, return a high fitness
        if individual == 0:
            return 2 * self.length
        # Count the number of 1's, same as part i
        return individual.bit_count()


if __name__ == '__main__':
    c = Config()
    c.main()
