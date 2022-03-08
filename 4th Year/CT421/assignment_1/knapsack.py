#!/usr/bin/env python

import statistics
from random import randrange
import common
from numpy.random import randint
from dataclasses import dataclass
from matplotlib import pyplot as plt


@dataclass
class Config(common.Config):
    knapsack_capacity: int
    values: list
    weights: list
    max_value: int
    fitness_best: list

    def __init__(self):
        super().__init__()
        self.knapsack_capacity = 6404180
        self.values = []
        self.weights = []
        self.read_in_values_weights()
        self.max_value = (1 << len(self.values)) - 1
        self.fitness_best = []
        self.length = 24
        # run a few more generations this time
        self.num_of_iterations = 25

    def read_in_values_weights(self):
        with open("values.txt", "r") as values_file:
            for line in values_file.readlines():
                self.values.append(int(line))
        with open("weights.txt", "r") as weights_file:
            for line in weights_file.readlines():
                self.weights.append(int(line))

    def main(self):
        population = []
        for x in range(10):
            self.population_size = self.population_size = randrange(20, 180, 2)
            print("Population size: ", self.population_size)
            # Generate a population of individuals
            for i in range(0, self.population_size):
                population.append(randint(0, self.max_value + 1))

            self.knapsack_genetic_algorithm(population)
            self.knapsack_plot()
            population = []
            self.fitness_best = []
            self.fitness_averages = []

    def knapsack_genetic_algorithm(self, population):
        best = 0

        # run num_of_iterations generations
        for generation in range(self.num_of_iterations):
            # calculate the fitness's for each individual
            scores = [self.fitness(x) for x in population]
            self.fitness_averages.append(statistics.fmean(scores))

            # get the best individual in regard to fitness
            best_individual_score = max(scores)
            self.fitness_best.append(best_individual_score)
            # If this individuals score is better than the best,
            # set this individual as the best
            if best_individual_score > self.fitness(best):
                best = population[scores.index(max(scores))]

            parents = []
            children = []

            # all the below is the same as part i
            # best individuals in the population chosen for crossover
            for i in range(self.population_size):
                parents.append(self.tournament_selection(population, scores))

            # do the crossover
            for i in range(0, self.population_size, 2):
                for child in self.crossover(parents[i], parents[i + 1]):
                    child = self.make_mutation(child)
                    children.append(child)

            population = children
        return best, self.fitness(best)

    def fitness(self, individual):
        sum_values = 0
        sum_weights = 0

        individual = str(format(individual, 'b'))
        for index, i in enumerate(individual):
            if i != '0':
                sum_values += self.values[index]
                sum_weights += self.weights[index]

        if sum_weights <= self.knapsack_capacity:
            return sum_values
        return 0

    def knapsack_plot(self):
        plt.plot(range(1, self.num_of_iterations + 1), self.fitness_averages, label='Average Fitness')
        plt.plot(range(1, self.num_of_iterations + 1), self.fitness_best, label='Best Fitness')
        plt.legend(['Average Fitness', 'Best Fitness'])
        # Display as normal numbers instead of scientific notation
        plt.ticklabel_format(style='plain')
        plt.ylabel('Fitness')
        plt.xlabel('Generation')
        plt.title(f'Average fitness and best fitness over {self.num_of_iterations} generations')
        plt.grid(True)
        plt.show()
        print("Showing Plot...")


if __name__ == '__main__':
    c = Config()
    c.main()
